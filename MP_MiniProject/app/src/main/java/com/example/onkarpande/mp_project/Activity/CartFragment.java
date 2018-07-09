package com.example.onkarpande.mp_project.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.onkarpande.mp_project.Adapter.BackgroundWorker;
import com.example.onkarpande.mp_project.Entity.ItemMenu;
import com.example.onkarpande.mp_project.R;

import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private Button order;
    private RecyclerView.Adapter adapter;
    private List<ItemMenu> itemMenus;
    private TextView total_order;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView=root.findViewById(R.id.recycler_view_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        itemMenus=((HomeActivity)getActivity()).getDefaults();

        setRecyclerAdapter(itemMenus);

        order=root.findViewById(R.id.order_btn);
        total_order=root.findViewById(R.id.total_order);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ItemMenu> itms=((HomeActivity)getContext()).getDefaults();
                if(itms!=null)
                {
                    ((HomeActivity)getContext()).setOrderFragment(itms);
                    BackgroundWorker backgroundWorker=new BackgroundWorker(getContext());
                    String order="";
                    for(ItemMenu x:itms)
                    {
                        order+=x.getName()+"  Q:"+x.getQuantity()+"\n";
                    }
                    String type="placeOrder";
                    String user=getUserName();
                    backgroundWorker.execute(type,user,order);
                    //Toast.makeText(getContext(),"Order has been placed , see History ...",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(),"No item added to cart ",Toast.LENGTH_SHORT).show();
                }
                ((HomeActivity)getContext()).setClear();
                ((HomeActivity)getContext()).setCartItemsNull();
                 setRecyclerAdapter(null);
            }
        });

        return root;
    }

    public void refreshFragment()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(CartFragment.this).attach(CartFragment.this).commit();
    }

    public void setRecyclerAdapter(List<ItemMenu> cartItemList)
    {
        if(cartItemList==null)
        {
            recyclerView.setVisibility(View.GONE);
        }
        else
        {
            adapter=new CartAdapter(cartItemList,getContext());
            int grandTotal=0;
            for(ItemMenu itm:cartItemList)
            {
                grandTotal+=Integer.parseInt(itm.getPrice())*itm.getQuantity();
            }
            //total_order.setText("Place order of"+grandTotal+" ₹");
            recyclerView.setAdapter(adapter);
        }
    }

    public String getUserName()
    {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        return appSharedPrefs.getString("user", "");
    }

    class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

        private List<ItemMenu> cartMenus;
        private Context context;

         CartAdapter(List<ItemMenu> itemMenus,Context context)
        {
            this.cartMenus=itemMenus;
            this.context=context;
        }
        @Override
        public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ItemMenu cartMenu=cartMenus.get(position);
            holder.mPrice.setText("Price : "+cartMenu.getPrice()+" ₹");
            holder.mName.setText(cartMenu.getName());
            holder.mQuantity.setText("Quantity : "+cartMenu.getQuantity());
           final String cartId = cartMenu.getId();

            Glide.with(this.context)
                    .load(cartMenu.getUrl())
                    .placeholder(R.drawable.ic_person_black_24dp)    // any placeholder to load at start
                    .error(R.drawable.ic_lock_black_24dp)            // any image in case of error
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.mImage);

            holder.cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<ItemMenu> cartItems=((HomeActivity)context).getDefaults();
                    for(ItemMenu it:cartItems)
                    {
                        if(it.getId().equals(cartId)) {
                            if(it.getQuantity()>1)
                            {
                                it.setQuantity(it.getQuantity()-1);
                            }
                            else
                            {
                                cartItems.remove(it);
                            }
                            break;
                        }
                    }
                    ((HomeActivity)getContext()).setClear();
                    ((HomeActivity)getContext()).setCartItemsNull();
                    ((HomeActivity)context).setWholeArray(cartItems);
                    cartMenus=cartItems;
                    setRecyclerAdapter(cartMenus);
                }
            });
            holder.addTocart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    List<ItemMenu> cartItems=((HomeActivity)context).getDefaults();
                    for(ItemMenu it:cartItems)
                    {
                        if(it.getId().equals(cartId)) {
                            it.setQuantity(it.getQuantity()+1);
                            break;
                        }
                    }
                    ((HomeActivity)getContext()).setClear();
                    ((HomeActivity)getContext()).setCartItemsNull();
                    ((HomeActivity)context).setWholeArray(cartItems);
                    cartMenus=cartItems;
                    setRecyclerAdapter(cartMenus);
                }
            });


        }

        @Override
        public int getItemCount() {
            return cartMenus.size();
        }

         class ViewHolder extends RecyclerView.ViewHolder{

             TextView mPrice;
             TextView mName;
             TextView mQuantity;
             ImageView mImage;
             ImageButton cart;
             ImageButton addTocart;

             ViewHolder(final View itemView) {
                super(itemView);
                mPrice=itemView.findViewById(R.id.menu_price);
                mName=itemView.findViewById(R.id.menu_name);
                mQuantity=itemView.findViewById(R.id.menu_qt);
                mImage=itemView.findViewById(R.id.menu_image);
                cart=itemView.findViewById(R.id.remove_from_cart);
                addTocart=itemView.findViewById(R.id.add_to_cart);
            }
        }
    }
}
