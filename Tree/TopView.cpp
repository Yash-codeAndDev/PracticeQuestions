// problem link :- https://www.hackerrank.com/challenges/tree-top-view/problem?isFullScreen=true

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

    void topView(Node * root) {
        
        queue<pair<Node* , pair<int,int>>> Q;
        
        // map< line, data>
        map<int, int> mp;
        
        Q.push({root , {0,0}});
        
        while( !Q.empty()){
            
            auto temp  = Q.front();
            Q.pop();
            
            Node* curr = temp.first;
            
            int line = temp.second.first;
            int level = temp.second.second;
            
            if(mp.find(line) == mp.end()){
                mp[line] = curr->data;
            }
            if(curr->left){
                Q.push( {curr->left, {line-1, level+1}});
            }
            if(curr->right){
                Q.push( {curr->right, {line+1, level+1}});
            }   
        }
        
        for(auto itr : mp){
            cout<<itr.second<<" ";
        }

    }
}; //End of Solution

int main() {
    
    Solution myTree;
    Node* root = NULL;
    
    int t;
    int data;

    std::cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }
  
    myTree.topView(root);

    return 0;
}
