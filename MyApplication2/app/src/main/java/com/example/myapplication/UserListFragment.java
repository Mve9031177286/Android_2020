package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UserListFragment extends Fragment {
    private RecyclerView userRecyclerView; // создаем переменную
    @Override
    public View onCreateView(LayoutInflater Inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = Inflater.inflate(R.layout.fragment_user_list, viewGroup,false); //вью - создали
        userRecyclerView = view.findViewById(R.id.userRecyclerView);// подружиться с ресайклер вью вызываем метод,
        // идентификатор - как обычно. все, теперь здесь тот самый ресайклер вью - это список
        // и надо создать еще элементы списка
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));// специальный менеджер,
        // отвечает за добавление элементов на ресайклер вью. ЛинерЛояут - виджет,  выводящий в данном случае,
        // горизонтальные ячейки, последовательно, с помощью менеджера
        return view;
    }

    private class UserHolder extends RecyclerView.ViewHolder{
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup){
            super(inflater.inflate(R.layout.list_item_user, viewGroup, false));
            //  вспомогательный класс, наследует от Вьюхолдер
        }
    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder> { // делаем адаптор,
        // обязательно указать тот вьюхолдер, который используем для этого адаптора
        private List<User> users;
        public UserAdapter(List<User> users){
            this.users = users;
        }

        @NonNull
        @Override
        public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { // создает элемент списка
            LayoutInflater inflater = LayoutInflater.from(getActivity()); // нужно вернуть ему этот элемент. возвращаем инфлятером
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}
