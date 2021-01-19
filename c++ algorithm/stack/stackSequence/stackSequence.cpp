#include <iostream>
#include <stack>
using namespace std;

int main() {
    int n, l;
    cin >> n;
    l = n;
    stack<int> s, t;
    int m, x = 0, i = 0;
    char arr[2000001];

    while(l) {
        t.push(l--);
    }

    while(n--) {
        cin >> m;

        if (m > x) {
            while(m > x) {
                x = t.top();
                t.pop();
                s.push(x);
                arr[i++] = '+'; 
            }
            s.pop();
            arr[i++] = '-';
        } else {
            x = s.top();
            s.pop();
            arr[i++] = '-';
            if(m != x) {
                cout << "NO" << '\n';
                return 0;
            }
        }
    }

    for(int j = 0; j < i; j++) {
        cout << arr[j] << '\n';
    }

    return 0;
}
