package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";

    StaticLayout staticLayout;

    // 若这样写 是在类加载的时候就初始化了 而不是创建对象的时候 此时textPaint还没有被设置size
//    StaticLayout staticLayout = new StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0 , true);

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 每次创建View的时候都会被初始化
        textPaint.setTextSize(60);
        staticLayout = new StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0 , true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.save();
        canvas.translate(50, 100);
        // 代替方法
        staticLayout.draw(canvas);
        canvas.restore();
//        canvas.drawText(text, 50, 100, textPaint);
    }
}
