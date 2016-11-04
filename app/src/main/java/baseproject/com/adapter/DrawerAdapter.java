package baseproject.com.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import baseproject.com.activity.R;

/**
 * Created by lin on 28/6/16.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.drawerHolder> {

    ArrayList<String> list = new ArrayList<>();


    public DrawerAdapter(ArrayList<String> list) {
        this.list = list;
    }

    public void setUpDateList(ArrayList<String> list) {
        this.list = list;

    }


    /**
     * First of all this method is called which inflate
     * the view and create viewHolder with it.
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public drawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_adapter, parent, false);
        return new drawerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(drawerHolder holder, int position) {

        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class drawerHolder extends RecyclerView.ViewHolder {

        TextView name, info;


        public drawerHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txt_name);


        }
    }
}
