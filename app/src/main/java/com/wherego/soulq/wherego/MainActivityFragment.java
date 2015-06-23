package com.wherego.soulq.wherego;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivityFragment extends Fragment {

    private RecyclerView rvPlaces;
    private static RecyclerView rvComments;
    private static MyApplication myApp;
    private TextView tvName;
    private TextView tvAbout;
    private static EditText txtType;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        myApp = (MyApplication) getActivity().getApplicationContext();

        SliderLayout sliderShow = (SliderLayout) view.findViewById(R.id.slider);

        TextSliderView textSliderView1 = new TextSliderView(getActivity());
        textSliderView1.image(R.drawable.pic_one).setScaleType(BaseSliderView.ScaleType.Fit);
        sliderShow.addSlider(textSliderView1);

        TextSliderView textSliderView2 = new TextSliderView(getActivity());
        textSliderView2.image(R.drawable.pic_two).setScaleType(BaseSliderView.ScaleType.Fit);
        sliderShow.addSlider(textSliderView2);


        tvName = (TextView) view.findViewById(R.id.tvName);
        tvAbout = (TextView) view.findViewById(R.id.tvAbout);

        tvName.setText("Рекорды Петербурга");
        tvAbout.setText("Петербург - уникальный в прямом смысле слова город. Здесь располгаются здания, мосты, улицы, площади и другие обьекты, равных которым нет во всем мире. Самые интересные из них - в нашей подборке.");

        txtType = (EditText) view.findViewById(R.id.txtType);

        // Configure RecyclerView Places
        rvPlaces = (RecyclerView) view.findViewById(R.id.rvPlaces);
        rvPlaces.setHasFixedSize(true);

        rvPlaces.setAdapter(new RvPlacesAdapter(R.layout.rc_item_place, getActivity(), myApp.getPlacesList()));
        rvPlaces.setItemAnimator(new DefaultItemAnimator());
        rvPlaces.setLayoutManager(new CustomLinearLayoutManager(view.getContext(), 1, false));

        myApp.addItem(new Places(
                "drawable://" + R.drawable.pic_one,
                "Станция метро «Адмиралтейская»",
                "Малая Морская улица",
                "Станция метро «Адмиралтейская» вступила в строй действующих 28 декабря 2011 года"
        ));
        myApp.addItem(new Places(
                "drawable://" + R.drawable.pic_two,
                "Лабиринт от KudaGo",
                "Some place",
                "Some text"
        ));

        myApp.addItem(new Places(
                "drawable://" + R.drawable.pic_one,
                "Клуб «Пропаганда»",
                "",
                "Самый легендарный столичный клуб, с которого и началась история клубного движения Москвы в 1997 году."
        ));
        myApp.addItem(new Places(
                "drawable://" + R.drawable.pic_two,
                "ТЦ «Цветной»",
                "Цветной бульвар 15, стр. 1",
                "Вещи в стиле luxury и casual в магазине «Цветной»!"
        ));
        rvPlaces.getAdapter().notifyDataSetChanged();

        // Configure RecyclerView Comments
        rvComments = (RecyclerView) view.findViewById(R.id.rvComments);
        rvComments.setHasFixedSize(true);

        rvComments.setAdapter(new RvCommentsAdapter(R.layout.rc_item_comment, getActivity(), myApp.getCommentsList()));
        rvComments.setItemAnimator(new DefaultItemAnimator());
        final CustomLinearLayoutManager mllm = new CustomLinearLayoutManager(view.getContext(), 1, true);
        rvComments.setLayoutManager(mllm);

        myApp.addItem(new Comments(
                "drawable://" + R.drawable.ic_account_grey600_48dp,
                "Алена",
                "",
                "19 May, 17:52"
        ));
        myApp.addItem(new Comments(
                "drawable://" + R.drawable.ic_account_grey600_48dp,
                "Екатерина",
                "Amazing",
                "31 May, 14:06"
        ));
        myApp.addItem(new Comments(
                "drawable://" + R.drawable.ic_account_grey600_48dp,
                "НАСТЯ",
                "Круто",
                "30 May, 20:57"
        ));
        myApp.addItem(new Comments(
                "drawable://" + R.drawable.ic_account_grey600_48dp,
                "Елена Павлова",
                "Cool",
                "05 June, 09:35"
        ));
        rvComments.getAdapter().notifyDataSetChanged();

        return view;
    }

    public static void addComment(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, HH:mm");
        myApp.addItem(new Comments("drawable://" + R.drawable.ic_account_grey600_48dp,
                "Anoun",
                txtType.getText().toString(),
                sdf.format(new Date())
        ));
        txtType.setText("");
        rvComments.getAdapter().notifyDataSetChanged();
    }
}
