package com.c1ctech.androiddagger2example.binding_adatpers;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.c1ctech.androiddagger2example.util.Constant;
import androidx.databinding.BindingAdapter;

public class BindingAdatpers {
    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(Constant.Api.BASE_IMAGE_URL + imageUrl).into(view);
    }
}