package com.example.mynavapp2.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mynavapp2.R;
import com.example.mynavapp2.viewmodel.TodoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListFragment extends Fragment {
        FloatingActionButton button;
    ProgressBar loadingView;
    TextView errorText;
    RecyclerView listItem;

    private TodoViewModel viewModel;
    private TodoAdapter todoAdapter = new TodoAdapter();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view ;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        button = view.findViewById(R.id.listFAB);
        loadingView = view.findViewById(R.id.progressBar);
        errorText = view.findViewById(R.id.errorText);
        listItem = view.findViewById(R.id.listItem);


        viewModel.todos.observe(getViewLifecycleOwner(), todos -> {
            if(todos != null) {
                todoAdapter.updateTodoList(todos);
                listItem.setVisibility(View.VISIBLE);
            }
        });
        viewModel.loading.observe(getViewLifecycleOwner(), loading -> {
            loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);

            if(loading) {
                errorText.setVisibility(View.GONE);
                listItem.setVisibility(View.GONE);
            }
        });

        viewModel.loading.observe(getViewLifecycleOwner(), error -> {
            errorText.setVisibility(error ? View.VISIBLE : View.GONE);
        });


        viewModel.refresh();

        if(listItem != null) {
            listItem.setLayoutManager((new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)));
            listItem.setAdapter(todoAdapter);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_go_to_detail_fragment);
            }
        });
    }
}