//! Q1 To show all the balanced parenthesis

#include <bits/stdc++.h>
using namespace std;

void solve(string output, int right, int left, int &count)
{
    if (left == 0 && right == 0)
    {
        count++;
        // cout << output << endl;
        return;
    }
    if (right != 0)
    {
        output += "(";
        right--;
        solve(output, right, left, count);
    }
    if (left > right)
    {
        output += ")";
        left--;
        solve(output, right, left, count);
    }
    // if (right == left)   Mine Code
    // {
    //     output += "(";
    //     right--;
    //     solve(output, right, left, count);
    // }
    // else if (right == 0 & left > 0)
    // {
    //     output += ")";
    //     left--;
    //     solve(output, right, left, count);
    // }
    // else
    // {
    //     string c1 = output + "(";
    //     string c2 = output + ")";
    //     int rightCount = right - 1;
    //     int leftCount = left - 1;
    //     solve(c1, rightCount, left, count);
    //     solve(c2, right, leftCount, count);
    // }
}

int main()
{
    int n = 20, right, left, m = 0;
    left = right = n;
    string output = "";
    solve(output, right, left, m);
    cout << m;
    return 0;
}