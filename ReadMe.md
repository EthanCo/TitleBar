# TitleBar #
Android 标题栏封装，方便使用  

![](http://oqk78xit2.bkt.clouddn.com/17-7-7/53239840.jpg)

## 添加依赖  
### Step 1. Add the JitPack repository to your build file  
Add it in your root build.gradle at the end of repositories:  
```Grovy
allprojects {
	repositories {
		...
maven { url 'https://www.jitpack.io' }
	}
}
```  

### Step 2. Add the dependency  
```Grovy
dependencies {
    compile 'com.github.EthanCo:TitleBar:1.0.5'
}
```  
## 使用  
在布局中添加TitleBar即可  

```xml
<com.ethanco.titlebar.TitleBar
    android:id="@+id/title_bar"
    android:layout_width="match_parent"
    android:layout_height="48dp"
    android:background="@color/colorAccent"
    app:bottom_divider_color="#000000"
    app:bottom_divider_visible="true"
    app:leftIc="@drawable/ic_back_arrow"
    app:leftIc_LeftPadding="16dp"
    app:leftIc_RightPadding="8dp"
    app:leftText="返回"
    app:bar_text_color="#FFF"
    app:title_textSize="20sp"
    app:common_textSize="16sp"
    app:title="标题">  
```

### 可使用的属性  


属性 | 说明
---|---
title | 标题
title_textSize | 标题字体大小
common_textSize | 其他字体大小
bar_text_color | 文字颜色
leftText | 左边的文字
leftIc | 左边的图片
leftText_LeftPadding | 左边的文字的leftPadding
leftText_RightPadding | 左边的文字的rightPadding
leftIc_LeftPadding | 左边的图片的leftPadding
leftIc_RightPadding | 左边的图片的rightPadding
rightText | 右边的文字
rightIc | 右边的图片
rightText_LeftPadding | 右边的文字的leftPadding
rightText_RightPadding | 右边的文字的rightPadding
rightIc_LeftPadding | 右边的图片的leftPadding
rightIc_RightPadding | 右边的图片的rightPadding
bottom_divider_color | 底部divider颜色
bottom_divider_visible | 底部divider是否可见  

### 设置监听  
#### setOnLeftClickListener  
设置左边的OnClick监听事件  

#### setOnRightClickListener  
设置右边的OnClick监听事件  

#### setTitle  
设置标题

#### setLeftText
设置左边文字

#### setRightText
设置右边文字