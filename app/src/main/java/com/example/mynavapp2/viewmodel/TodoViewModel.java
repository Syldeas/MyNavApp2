package com.example.mynavapp2.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.mynavapp2.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoViewModel extends ViewModel {
    public MutableLiveData<List<Todo>> todos = new MutableLiveData<List<Todo>>();

    public MutableLiveData<Boolean> loadError = new MutableLiveData<Boolean>();

    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    public void refresh() {
        Todo todo1 = new Todo("First Todo1", false);
        Todo todo2 = new Todo("First Todo2", false);
        Todo todo3 = new Todo("First Todo3", false);
        Todo todo4 = new Todo("First Todo4", false);
        List<Todo> todoList = new ArrayList<>();

        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);
        todoList.add(todo4);

        todos.setValue(todoList);
        loadError.setValue(false);
        loading.setValue(false);
    }
}
