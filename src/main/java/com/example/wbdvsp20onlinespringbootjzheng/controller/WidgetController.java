package com.example.wbdvsp20onlinespringbootjzheng.controller;

import com.example.wbdvsp20onlinespringbootjzheng.models.Widget;
import com.example.wbdvsp20onlinespringbootjzheng.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {
    WidgetService widgetService = new WidgetService();

    @PostMapping("/topics/{topicId}/widgets")
    public Widget createWidget(@PathVariable("topicId") String tid, @RequestBody Widget widget) {
        return widgetService.createWidget(tid, widget);
    }

//    @PostMapping("/widgets")
//    public int moveWidget(@RequestBody Widget widget) {
//        return widgetService.moveWidget(widget);
//    }

    @GetMapping("/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("topicId") String tid) {
        return widgetService.findWidgetsForTopic(tid);
    }

    @PutMapping("/widgets/{widgetId}")
    public int updateWidget(@PathVariable("widgetId") String wid,
                            @RequestBody Widget widget) {
        return widgetService.updateWidget(wid, widget);
    }

    @DeleteMapping("/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") String wid) {
        return widgetService.deleteWidget(wid);
    }


//    @GetMapping("/widgets")
//    public List<Widget> findAllWidget() {
//        return widgetService.findAllWidget();
//    }



}
