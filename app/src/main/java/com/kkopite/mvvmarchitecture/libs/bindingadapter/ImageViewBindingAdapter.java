package com.kkopite.mvvmarchitecture.libs.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by kkopite on 2018/10/29.
 */

public class ImageViewBindingAdapter {

    @BindingAdapter(value = {"uri", "placeholderImageRes", "request_width", "request_height"}, requireAll = false)
    public static void loadImage(final ImageView imageView, String uri,
                                 @DrawableRes int placeholderImageRes,
                                 int width, int height) {
        imageView.setImageResource(placeholderImageRes);
        if (!TextUtils.isEmpty(uri)) {

            Glide.with(imageView.getContext()).load(uri).into(imageView);

//            ImagePipeline imagePipeline = Fresco.getImagePipeline();
//            ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(uri));
//            if (width > 0 && height > 0) {
//                builder.setResizeOptions(new ResizeOptions(width, height));
//            }
//            ImageRequest request = builder.build();
//            DataSource<CloseableReference<CloseableImage>>
//                    dataSource = imagePipeline.fetchDecodedImage(request, imageView.getContext());
//            dataSource.subscribe(new BaseBitmapDataSubscriber() {
//                @Override
//                protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
//                    if (onFailureCommand != null) {
//                        onFailureCommand.execute(dataSource);
//                    }
//                }
//
//                @Override
//                protected void onNewResultImpl(Bitmap bitmap) {
//                    imageView.setImageBitmap(bitmap);
//                    if (onSuccessCommand != null) {
//                        onSuccessCommand.execute(bitmap);
//                    }
//                }
//            }, UiThreadImmediateExecutorService.getInstance());
        }
    }
}
