package MyAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.list_view.R;

import java.util.List;

import Model.Person;

public class MyAdapter extends BaseAdapter {
    private Activity context;
    private List<Person> personList;
    private LayoutInflater inflater;

    public MyAdapter(Activity context, List<Model.Person> personList) {
        this.context = context;
        this.personList = personList;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private static class viewHolder {
        private ConstraintLayout parent;
        private TextView txtFname, txtLname;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        viewHolder holder = new viewHolder();

        if (v == null) {

            v = inflater.inflate(R.layout.list_view, null);

            holder.parent = v.findViewById(R.id.layout);
            holder.txtFname = v.findViewById(R.id.firstName_view);
            holder.txtLname = v.findViewById(R.id.lastName_view);

            v.setTag(holder);

        } else
            holder = (viewHolder) v.getTag();

        if (personList.size() > 0) {
            holder.txtFname.setText(personList.get(i).getFirstName());
            holder.txtLname.setText(personList.get(i).getLastName());
        }

        return v;
    }
}
