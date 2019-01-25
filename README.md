# BestActivityResult

[![Download](https://api.bintray.com/packages/hurryyu/maven/BestActivityResult/images/download.svg?version=1.0.0)](https://bintray.com/hurryyu/maven/BestActivityResult/1.0.0/link)

## 怎么下载（How to download）

在要使用本库的`module`的`build.gradle`中添加以下代码（Add the following code to `build.gradle` of the `module` to use the library）：

```groovy
implementation 'com.hurryyu:BestActivityResult:last-version'
```

请自行将`last-version`替换为最新版本号（Please replace `last-version` with the latest version number）

## 怎么使用（How to use）

如果你的项目中使用了`BaseActivity`，你可以定义一个成员变量，并在`onCreate`中对它进行初始化（If `BaseActivity` is used in your project, you can define a member variable and initialize it in `onCreate`.）：

```java
protected BestActivityResult mBestActivityResult;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    mBestActivityResult = new BestActivityResult(this);
    ...
}
```

你也可以不在`BaseActivity`中定义并初始化，而是在需要使用的地方进行初始化。（You can also not define and initialize it in `BaseActivity`,but in the place where you need to use initialize.）

现在，当你需要启动一个`Activity`并需要得到它的返回结果时，完全不必再去重写`onActivityResult`，并在里面进行大量的逻辑判断来区分返回结果是属于哪个`requestCode`。现在，你只需要这样做（Now,when you need to start a ` Activity ` and need return results from it, completely don't have to rewrite ` onActivityResult `, and in a large number of logical judgment to distinguish return result is belong to which ` requestCode `.Now, you just need to do this）：

```java
mBtnOpen.setOnClickListener(v ->
    mBestActivityResult.start(ResultActivity.class, (resultCode, data) -> {
    	//在这里处理返回结果,不必关心requestCode
    })
);
```

## 感谢使用（Thank you for using）

如果你在使用过程中遇到任何问题，或是有更好的建议，欢迎与我联系，谢谢！
If you encounter any problems or have better suggestions, please feel free to contact me, thank you!