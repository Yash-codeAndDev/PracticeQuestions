// problem link -> https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem


/*
    For -> BST
    Assuming : Both Node Exist
    Intution -> The node at which value1 and value2 start to deviate (moves in different path) is the LCA

*/

#include<bits/stdc++.h>
using namespace std;

class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

class Solution {
    public:
  		Node* insert(Node* root, int data) {
            if(root == NULL) {
                return new Node(data);
            } else {
                Node* cur;
                if(data <= root->data) {
                    cur = insert(root->left, data);
                    root->left = cur;
                } else {
                    cur = insert(root->right, data);
                    root->right = cur;
                }

               return root;
           }
        }

    Node* LCA(Node* root, int v1,int v2) 
    {

        if(root->data > v1 && root->data > v2){
            return LCA(root->left, v1, v2);
        }        
        
        if(root->data < v1 && root->data < v2){
            return LCA(root->right, v1, v2);
        }        

        return root;
    }
}; //End of Solution

int main() {
    
    Solution myTree;
    Node* root = NULL;
    
    int t;
    int data;
    int v1 , v2;
    cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }
    
    cin>>v1>>v2;

    cout<<"LCA of "<<v1<<" and "<<v2<<"  : "<< myTree.LCA(root,v1,v2)->data;

    return 0;
}
