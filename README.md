# README

- ## [Leetcode Editor](https://github.com/shuzijun/leetcode-editor)

```
LC$!velocityTool.deleteWhitespace("${question.frontendQuestionId}${velocityTool.camelCaseName(${question.titleSlug})}")
```

```
package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

//${question.frontendQuestionId} ${question.title}
public class LC$!velocityTool.deleteWhitespace("${question.frontendQuestionId}${velocityTool.camelCaseName(${question.titleSlug})}"){
    public static void main(String[] args) {
        System.out.println("Leetcode " + "${question.frontendQuestionId}");
        Solution solution = new LC$!velocityTool.deleteWhitespace(${question.frontendQuestionId})$!velocityTool.deleteWhitespace($!velocityTool.camelCaseName(${question.titleSlug}))().new Solution();
        
    }
    
    
${question.code}
}
```

- [LeetCodeHelper Class](src/main/java/com/leetcode/helper/LeetCodeHelper.java)
