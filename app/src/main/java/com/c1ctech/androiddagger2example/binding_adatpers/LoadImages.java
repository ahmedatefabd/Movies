package com.c1ctech.androiddagger2example.binding_adatpers;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.c1ctech.androiddagger2example.util.Constant;

public class LoadImages {
    @BindingAdapter({"app:loadImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(Constant.Api.BASE_IMAGE_URL + imageUrl).into(view);
    }
}
