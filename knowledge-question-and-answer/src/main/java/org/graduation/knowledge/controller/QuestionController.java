package org.graduation.knowledge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.service.QuestionService;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huyuanxin
 */
@CrossOrigin
@RestController
@RequestMapping("/QA")
@Api(tags = "智能问答接口")
public class QuestionController {

    final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    @ApiOperation(tags = "智能问答接口", value = "问答", response = Result.class, httpMethod = "POST")
    public Result<String> questionAndAnswer(@RequestBody String input) {
        return ResultUtil.success(questionService.answer(input));
    }

}
