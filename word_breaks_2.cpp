class Solution {
public:
    vector<string> solve(string s, unordered_map<string, bool> &words, int i){
        if(i >= s.size()) return {""};

        string word;
        vector<string> ans;

        for(int j = i; j<s.size(); j++){
            word += s[j];
            if(words.find(word) == words.end()) continue;
            //word found
            auto rightPart = solve(s, words, j+1);
            for(auto part: rightPart){
                string end;
                if(part.size() > 0) end += " " + part;
                ans.push_back(word + end);
            }
            
        }
        return ans;
    }

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_map<string, bool> words;
        for(auto i : wordDict){
            words[i] = 1;
        }
        return solve(s, words, 0);
    }
};
