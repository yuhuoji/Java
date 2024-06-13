# README

- ## [Leetcode Editor](https://github.com/shuzijun/leetcode-editor)

```
LC${question.frontendQuestionId}$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug}))
```

```
package com.leetcode.editor.cn;

import com.leetcode.helper.*;

//${question.frontendQuestionId} ${question.title}
public class LC${question.frontendQuestionId}$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug})){
    public static void main(String[] args) {
        System.out.println("Leetcode " + ${question.frontendQuestionId});
        Solution solution = new LC${question.frontendQuestionId}$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug}))().new Solution();
        
    }
${question.code}
}
```

- [LeetCodeHelper Class](src/main/java/com/leetcode/helper/LeetCodeHelper.java)
