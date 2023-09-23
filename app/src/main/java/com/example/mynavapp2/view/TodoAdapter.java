package com.example.mynavapp2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavapp2.R;
import com.example.mynavapp2.model.Todo;

import java.util.ArrayList;
import java.util.List;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    static ArrayList<Todo> todos = new ArrayList<>();
    Context context;
    private OnItemClickListener clicklistener;

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        context = parent.getContext();
//        return new RecyclerView.ViewHolder(inflate);
        return new ViewHolder(inflate);
    }

    public void updateTodoList(List<Todo> newTodo) {
        todos.clear();
        todos.addAll(newTodo);
        notifyDataSetChanged();
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }



    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.todoTitle.setText(todo.getTitle());
        holder.todoCheckBox.setChecked(todo.isCompleted());
        holder.bind(todo, clicklistener);
    }

public int getItemCount() { return todos.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView todoTitle;
        CheckBox todoCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            todoTitle = itemView.findViewById(R.id.todoTitle);
            todoCheckBox = itemView.findViewById(R.id.checkBoxCompleted);
        }
        public  void bind(Todo todo, OnItemClickListener listener) {
            todoTitle.setText((todo.getTitle()));
            todoCheckBox.setChecked(todo.isCompleted());
        }
    }

}
