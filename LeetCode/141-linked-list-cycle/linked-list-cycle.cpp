
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if (head == nullptr) return false;
        ListNode* run = head->next;
        ListNode* walk = head;

        while (run != nullptr && run->next != nullptr) {
            if (run == walk) return true;
            run = run->next->next;
            walk = walk->next;
        } //while

        return false;
    } //hasCycle
};