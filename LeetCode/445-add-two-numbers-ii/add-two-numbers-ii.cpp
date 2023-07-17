/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        deque<int> d1, d2;
        ListNode* sol = nullptr;
        int carry = 0;

        while (l1 != nullptr) {
            d1.push_back(l1->val);
            l1 = l1->next;
        } //while

        while (l2 != nullptr) {
            d2.push_back(l2->val);
            l2 = l2->next;
        } //while

        while (d1.size() != d2.size()) {
            if (d1.size() < d2.size()) {
                d1.push_front(0);
            } else {
                d2.push_front(0);
            } //if
        } //while

        //create our sol ll
        while (!d1.empty()) {
            int res = d1.back() + d2.back() + carry;
            d1.pop_back();
            d2.pop_back();
            carry = res >= 10 ? 1 : 0;
            if (sol == nullptr) {
                sol = new ListNode (res % 10);
            } else {
                ListNode * newHead = new ListNode (res % 10, sol);
                sol = newHead;
            } //if
        } //while

        //if carry overflows
        if (carry) {
            ListNode * newHead = new ListNode (1, sol);
            sol = newHead;
        } //if
        
        return sol;
    } //addTwoNums
};
