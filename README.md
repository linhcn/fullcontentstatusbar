# fullcontentstatusbar
This demo resolve matter how to make fully content screen up to status bar and some problem go with it

## The matter about fitsSystemWindows
* Insets are always relative to the full window — insets may be applied even before layout happens, so don’t assume the default behavior knows anything about the position of a View when applying its padding
* Any other padding you’ve set is overwritten — you’ll note that paddingLeft/paddingTop/etc is ineffective if you are using android:fitsSystemWindows="true" on the same View
* maybe you want your RecyclerView to scroll underneath a transparent navigation bar — by using android:fitsSystemWindows="true" in conjunction with android:clipToPadding="false", your scrolling content will be behind the controls but, when scrolled to the bottom, the last item will still be padded to be above the navigation bar (rather than hidden underneath!)
> Refering some prolem here https://medium.com/google-developers/why-would-i-want-to-fitssystemwindows-4e26d9ce1eec
