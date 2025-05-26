#!/usr/bin/env python3

# LeetCode Problem 79 Word Search
#
# Result:
# Runtime: 2148 ms beats 92%
# Memory Usage: 17.9 MB beats 40%

class Solution:

    class Node:
        def __init__(self, value: str):
            self.value = value
            self.next: set[Solution.Node] = set()

        def __repr__(self):
            return self.value + ": " + str([n.value for n in self.next])


    def exist(self, board: list[list[str]], word: str) -> bool:
        # Make map of char to possible next chars
        next_char: dict[str, set[str]] = dict()
        for c in word:
            next_char[c] = set()
        for i in range(len(word) - 1):
            next_char[word[i]].add(word[i + 1])
        # Convert board to graph, ignoring invalid connections
        # Start by making a new board of Nodes instead of strings
        board_nodes = [[Solution.Node(value) if value in next_char else None for value in row] for row in board]
        # Eventually we'll want a list of Nodes to try searching from
        nodes: list[Solution.Node] = list()
        # For each Node in the board, connect it to neighbors
        for row_i in range(len(board)):
            for col_i in range(len(board[row_i])):
                this_node = board_nodes[row_i][col_i]
                if this_node is None:
                    # this char is not in the word
                    continue
                nodes.append(this_node)
                next_nodes = []
                if row_i > 0:
                    next_nodes.append(board_nodes[row_i - 1][col_i])
                if row_i < len(board) - 1:
                    next_nodes.append(board_nodes[row_i + 1][col_i])
                if col_i > 0:
                    next_nodes.append(board_nodes[row_i][col_i - 1])
                if col_i < len(board[row_i]) - 1:
                    next_nodes.append(board_nodes[row_i][col_i + 1])
                next_chars = next_char[this_node.value]
                for next_node in next_nodes:
                    if next_node is not None and next_node.value in next_chars:
                        # Only save it as a connection if this character to that character
                        # occurs in the word.
                        this_node.next.add(next_node)

        # DFS from each valid starting node
        for node in nodes:
            if self.dfs(word, 0, set(), node):
                return True
        # Didn't find any
        return False
    
    def dfs(self, word: str, i: int, visited: set[Node], node: Node) -> bool:
        """ Recursive depth-first search function
        :param str word: The word we're searching for
        :param int i: The index in the word of the character we're trying to match now
        :param set[Node] visited: Set of Nodes already visited on this path
        :param Node node: The node we're currently at
        """
        if word[i] != node.value:
            return False
        if node in visited:
            return False
        if i == len(word) - 1:
            # This is a match and it's the end of the word, success!
            return True
        visited.add(node)
        for next_node in node.next:
            if self.dfs(word, i + 1, visited, next_node):
                return True
        visited.remove(node)
        return False

def main():
    """starts_here"""
    board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
    word = "ABCB"
    print(Solution().exist(board, word))
    

if __name__ == '__main__':
    main()