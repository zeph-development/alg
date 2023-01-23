from python.model.node import Node


def insert(node, data):
    if node is None:
        return Node(data)
    else:
        if data <= node.data:
            temp = insert(node.left, data)
            node.left = temp
            temp.parent = node
        else:
            temp = insert(node.right, data)
            node.right = temp
            temp.parent = node
        return node


def in_order_successor(node):
    if node.right is not None:
        return min_value(node.right)

    p = node.parent
    while p is not None:
        if node != p.right:
            break
        node = p
        p = p.parent
    return p


def min_value(node):
    current = node

    while current is not None:
        if current.left is None:
            break
        current = current.left
    return current


root = None
root = insert(root, 20)
root = insert(root, 9)
root = insert(root, 25)
root = insert(root, 5)
root = insert(root, 12)
root = insert(root, 11)
root = insert(root, 14)

# node selected is 9
successor = in_order_successor(root.left)
print(successor.data)
