#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    cin >> n;
    cin.ignore();

    int left = 0;
    string str;
    while(n--) {
        getline(cin, str);
        str += '\n';
        for (char ch : str) {
            if(ch == '(') {
                left++;
            } else if (ch == ')') {
                if(left == 0) {
                    cout << "NO" << '\n';
                    break;
                }
                left--;
            } else if (ch == '\n') {
                if(left == 0) {
                    cout << "YES" << '\n';
                } else {
                    cout << "NO" << '\n';
                }
            }
        }
        
        left = 0;
    }

    return 0;
}