package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Comment;
import com.epam.travelagency.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

/*    @RequestMapping(value = "/blog")
    public String showMessage(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.getAll());
        return "blog";
    }*/


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Comment comment) {
        comment.setMessage("Hello, this is the n message in my blog");
        comment.setDate(new Date(2018, 3, 12));
        commentService.save(comment);
        return "blog";
    }
}
