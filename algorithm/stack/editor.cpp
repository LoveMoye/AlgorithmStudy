#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;
    int n;
    cin >> n;

    stack<char> l, r;
    for(char ch : str) {
        l.push(ch);
    }

    string cmd;
    while(n--) {
        cin >> cmd;
        if(cmd == "L") {
            if(!(l.empty())) {    
                r.push(l.top());
                l.pop();
            }
        } else if (cmd == "D") {
            if(!(r.empty())) {
                l.push(r.top());
                r.pop();
            }   
        } else if (cmd == "B") {
            if(!(l.empty())) {
                l.pop();
            }
        } else if (cmd == "P") {
            char add;
            cin >> add;
            l.push(add);
        }
    }
    while(!(l.empty())) {
        r.push(l.top());
        l.pop();
    }

    while(!(r.empty())) {
        cout << r.top();
        r.pop();
    }

    cout << '\n';
    return 0;
}
