Depth first search -> As name indicate we first reach the depth and then starts traversing the tree.

            A
           B   C
          D E F G

      -> A B D E C F G => DLR (PreOrder is also Depth First search)
      -> D B E A F C G => LDR (Inorder is also Depth Firt search)
      -> D E B F G C A => LRD (Postorder is also DFS)


Depth-First Search (DFS) Algorithm: It starts with the root node and first visits all 
nodes of one branch as deep as possible of the chosen Node and before backtracking, 
it visits all other branches in a similar fashion.

# Inorder Traversal

Inorder Traversal is the one the most used variant of DFS(Depth First Search) Traversal of the tree.

As DFS suggests, we will first focus on the depth of the chosen Node and then go to the breadth at that level. T

> Important Fact: Inorder Traversal of Binary Search Tree will always give you Nodes in sorted manner.


# Preorder traversal
Preorder Traversal is another variant of DFS. Where atomic operations in a recursive function, are as same as Inorder traversal but with a different order.