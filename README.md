# README

- LeetCode Plugin

```
Leetcode${question.frontendQuestionId}$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug}))
```

```
package com.leetcode.editor.cn;

import com.leetcode.helper.*;

//${question.frontendQuestionId} ${question.title}
public class Leetcode${question.frontendQuestionId}$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug})){
    public static void main(String[] args) {
        System.out.println("Leetcode " + ${question.frontendQuestionId});
        Solution solution = new Leetcode${question.frontendQuestionId}$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug}))().new Solution();
        
    }
${question.code}
}
```

[note](src/main/java/com/leetcode/editor/cn/doc/)