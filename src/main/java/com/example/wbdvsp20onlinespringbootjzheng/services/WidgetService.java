package com.example.wbdvsp20onlinespringbootjzheng.services;
import com.example.wbdvsp20onlinespringbootjzheng.models.Topic;
import com.example.wbdvsp20onlinespringbootjzheng.models.Widget;
import com.example.wbdvsp20onlinespringbootjzheng.repositories.TopicRepository;
import com.example.wbdvsp20onlinespringbootjzheng.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public Widget createWidget(Integer tid, Widget newWidget) {
        Topic topic = topicRepository.findById(tid).get();
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }

    public List<Widget> findWidgetsForTopic(Integer tid) {
        return widgetRepository.findWidgetsForTopic(tid);
    }

    public Widget findWidgetById(Integer wid) {
        return widgetRepository.findWidgetById(wid);
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAllWidgets();
    }

    public int updateWidget(Integer wid, Widget updatedWidget) {
        Widget widgetToUpdate = widgetRepository.findWidgetById(wid);
        widgetToUpdate.setTitle(updatedWidget.getTitle());
        widgetToUpdate.setSize(updatedWidget.getSize());
        widgetToUpdate.setText(updatedWidget.getText());
        widgetToUpdate.setType(updatedWidget.getType());
        widgetRepository.save(widgetToUpdate);
        return 1;
    }

    public int deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
        return 1;
    }

}
