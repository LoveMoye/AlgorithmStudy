#include <iostream>
#include <string>
using namespace std;
struct Stack {
    // field
    int size;
    char data[30];
    
    Stack() {
        size = 0;
    }
    
    void push(char s) {
        data[size] = s;
        size++;
    }

    bool isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    char top() {
        return data[size-1];
    }

    char pop() {
        char pop = data[size-1];
        data[size-1] = 0;
        size--;
        return pop;
    }

    int getSize() {
        return size;
    }

    void print(char c) {
    while(!(isEmpty())) {
        cout << pop();
    }
    cout << c;
}
};

int main() {
    int n;
    cin >> n;
    
    Stack s;
    string str;
    cin.ignore();
    while(n-- > 0) {
        getline(cin, str);
        str += '\n';
        for(char c : str){
            if (c == ' ' || c == '\n') {
                s.print(c);
            } else {
                s.push(c);
            }
        } 
    }

    return 0;
}

