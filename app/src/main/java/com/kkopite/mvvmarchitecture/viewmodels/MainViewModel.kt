package com.kkopite.mvvmarchitecture.viewmodels;

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.kkopite.mvvmarchitecture.BR
import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.core.bean.test.User
import com.kkopite.mvvmarchitecture.libs.ActivityViewModel
import com.kkopite.mvvmarchitecture.ui.viewholders.BaseViewHolderFactory
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind

public interface MainViewModel {

    interface Inputs {

    }

    interface Outputs {

    }


    class ViewModel(application: Application) : ActivityViewModel(application), Inputs, Outputs {

        val inputs: Inputs = this
        val outpus: Outputs = this
        val text = MutableLiveData<String>()

        fun change(str: String) {
            text.value = str
        }

        val value = ObservableBoolean(false)

        val items: ObservableList<User> = ObservableArrayList<User>()
        //        val itemBinding: ItemBinding<User> = ItemBinding.of(BR.user, R.layout.item_test)
        val itemBinding = OnItemBind<User> { itemBinding, position, _ ->
            itemBinding.set(BR.user, R.layout.item_test)
                    // 将该viewModel传到item, 方便item里面的事件可以再改viewModel处理
                    .bindExtra(BR.viewmodel, this)
        }

        val viewHolderFactory = BaseViewHolderFactory()

        var id = 1

        fun onClickAddUser(view: View) {
            items.add(User("client$id", id))
            id++
            Toast.makeText(getApplication(), "hello world", Toast.LENGTH_SHORT).show()
        }

        fun onRemove(position: Int) {
            items.removeAt(position)
        }
    }

}