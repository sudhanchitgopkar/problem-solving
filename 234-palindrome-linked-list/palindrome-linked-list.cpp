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
    bool isPalindrome(ListNode* head) {
        ListNode* curr = head;
        stack<int> llvals;

        while (curr != nullptr) {
            llvals.push(curr->val);
            curr = curr->next;
        } //while

        curr = head;
        while (curr != nullptr) {
            if (curr->val != llvals.top()) {
                return false;
            } else {
                llvals.pop();
                curr = curr ->next;
            } //if
        } //while

        return true;
    } //isPalindrome
};