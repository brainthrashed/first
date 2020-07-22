package aldan.talba.rf;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class UlusyActivity extends AppCompatActivity {

	public final int REQ_CD_IMGFILES = 101;
	private Timer _timer = new Timer();

	private FloatingActionButton _fab;


	private WebView webview2;

	private Intent imgfiles = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent intent1 = new Intent();
	private TimerTask t;




	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
		_fab.hide();
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}

	@SuppressLint({"SetJavaScriptEnabled", "CutPasteId"})
	private void initialize() {

		Toolbar _toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = findViewById(R.id._fab);



		LinearLayout _nav_view = findViewById(R.id._nav_view);

		webview2 = findViewById(R.id.webview2);
		webview2.getSettings().setJavaScriptEnabled(true);
		webview2.getSettings().setSupportZoom(false);
		webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview2.getSettings().setAppCacheEnabled(true);

		// chromium, enable hardware acceleration
		webview2.setLayerType(View.LAYER_TYPE_HARDWARE, null);


		Switch _drawer_switch1 = _nav_view.findViewById(R.id.switch1);
		Button _drawer_button6 = _nav_view.findViewById(R.id.button6);
		imgfiles.setType("image/*");
		imgfiles.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		SharedPreferences shared = getSharedPreferences("Shareds", Activity.MODE_PRIVATE);

		webview2.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;

				_fab.hide();
				t = new TimerTask() {
					@Override
					public void run() {
					}
				};

				super.onPageStarted(_param1, _param2, _param3);
			}

			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				if (_param2.startsWith("file:///android_asset/www") || _param2.endsWith("/novoe-obyavlenie") || _param2.endsWith("/novoe-obyavlenie.html"))_fab.hide();
				else _fab.show();
				super.onPageFinished(_param1, _param2);
			}
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				if (url.startsWith("mailto:")) {
					//Handle mail Urls
					startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(url)));
				} else if (url.startsWith("tel:")) {
					//Handle telephony Urls
					startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
				}
				else if ((url.startsWith("https://wa.me/")) || (url.startsWith("https://play.google")) ||(url.startsWith("https://vk.com/")) || (url.startsWith("https://www.facebook.com/"))
						|| (url.startsWith("https://facebook.com/")) || (url.startsWith("viber://"))
						|| (url.startsWith("https://www.gismeteo")) || (url.startsWith("https://t.me")) || (url.startsWith("https://twitter.com/"))
						|| (url.startsWith("https://connect.ok.ru/")) || (url.startsWith("https://telegram.me/")) || (url.startsWith("https://api.")))
				{
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
				}

				else if (url.startsWith("file:///android_asset/www/index.html")) {
					webview2.clearHistory();
					_fab.hide();

				}
				else if (url.startsWith("https://instagram")) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(browserIntent);
				}
				else {
					view.loadUrl(url);;
				}
				return true;
			}

			@TargetApi(Build.VERSION_CODES.N)
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				final Uri uri = request.getUrl();
				final String url = uri.toString();
				if (url.startsWith("mailto:")) {
					//Handle mail Urls
					startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(url)));
				} else if (url.startsWith("tel:")) {
					//Handle telephony Urls
					startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
				}
				else if ((url.startsWith("https://wa.me/")) || (url.startsWith("https://play.google")) ||(url.startsWith("https://vk.com/")) || (url.startsWith("https://www.facebook.com/"))
						|| (url.startsWith("https://facebook.com/")) || (url.startsWith("viber://"))
						|| (url.startsWith("https://www.gismeteo")) || (url.startsWith("https://t.me")) || (url.startsWith("https://twitter.com/"))
						|| (url.startsWith("https://connect.ok.ru/")) || (url.startsWith("https://telegram.me/")) || (url.startsWith("https://api.")))
				{

					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
				}

				else if (url.startsWith("file:///android_asset/www/index.html")) {
					webview2.clearHistory();
				}
				else if (url.startsWith("https://instagram")) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(browserIntent);
				}
				else {
					view.loadUrl(url);;
				}
				return true;
			}

			@Override
			public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
				super.onReceivedError(view, request, error);
				view.loadUrl("file:///android_asset/www/index2.html");
			}
		});

		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview2.loadUrl("file:///android_asset/www/index2.html");
				webview2.clearHistory();
			}
		});

		_drawer_switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				if (_param2) {
					getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				}
				else {
					getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				}
			}
		});



		_drawer_button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent shareIntent = new Intent(Intent.ACTION_SEND); shareIntent.setType("text/plain"); shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Приложение Талба: все объявления Якутии"); shareIntent.putExtra(Intent.EXTRA_TEXT, "Скачать приложение Талба с Play Market можно по ссылке http://play.google.com/store/apps/details?id=project.talba.rf "); startActivity(Intent.createChooser(shareIntent, "Приложение талба: все объявления Якутии"));
			}
		});


	}
	@SuppressLint({"SetJavaScriptEnabled", "ObsoleteSdkInt"})
	private void initializeLogic() {
		setTitle("ТАЛБА улусы");
		_Fab_Color();


		webview2.setDownloadListener(new DownloadListener()
		{

			@RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
			@Override
			public void onDownloadStart(String url, String userAgent,
										String contentDisposition, String mimeType,
										long contentLength) {

				DownloadManager.Request request = new DownloadManager.Request(
						Uri.parse(url));

				request.setMimeType(mimeType);
				String cookies = CookieManager.getInstance().getCookie(url);
				request.addRequestHeader("cookie", cookies);
				request.addRequestHeader("User-Agent", userAgent);
				request.setDescription("Загрузка...");
				request.setTitle(URLUtil.guessFileName(url, contentDisposition,
						mimeType));

				request.allowScanningByMediaScanner();
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				request.setDestinationInExternalPublicDir(
						Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(
								url, contentDisposition, mimeType));
				DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				dm.enqueue(request);
				Toast.makeText(getApplicationContext(), "Загрузка файла",
						Toast.LENGTH_LONG).show();
			}});
		webview2.setWebChromeClient(new WebChromeClient() {

			// For Lollipop 5.0+ Devices
			public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
				if (uploadMessage != null) {
					uploadMessage.onReceiveValue(null);
					uploadMessage = null; } uploadMessage = filePathCallback;
				Intent intent = null;
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
					intent = fileChooserParams.createIntent();
				}
				try {
					startActivityForResult(intent, REQUEST_SELECT_FILE);
				} catch (ActivityNotFoundException e) {
					uploadMessage = null; Toast.makeText(getApplicationContext(), "Не удается открыть средство выбора файлов", Toast.LENGTH_LONG).show(); return false; }
				return true; }


		});
		webview2.setDownloadListener(new DownloadListener() { public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) { Intent intent = new Intent(Intent.ACTION_VIEW); intent.setData(Uri.parse(url)); startActivity(intent); } });
		registerForContextMenu(webview2);
		webview2.loadUrl("file:///android_asset/www/index2.html");


	}


	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);

		switch (_requestCode) {
			case REQ_CD_IMGFILES:
				if (_resultCode == Activity.RESULT_OK) {
					ArrayList<String> _filePath = new ArrayList<>();
					if (_data != null) {
						if (_data.getClipData() != null) {
							for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
								ClipData.Item _item = _data.getClipData().getItemAt(_index);
								_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
							}
						}
						else {
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
						}
					}

				}
				break;

			case REQUEST_SELECT_FILE:
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					if (uploadMessage == null) return; uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(_resultCode, _data)); uploadMessage = null; }
				break;

			case FILECHOOSER_RESULTCODE:
				if (null == mUploadMessage){
					return; }
				Uri result = _data == null || _resultCode != RESULT_OK ? null : _data.getData(); mUploadMessage.onReceiveValue(result);
				mUploadMessage = null;

				break;
			default:
				break;
		}
	}

	private ValueCallback<Uri> mUploadMessage;
	public ValueCallback<Uri[]> uploadMessage;
	public static final int REQUEST_SELECT_FILE = 100;

	private final static int FILECHOOSER_RESULTCODE = 1;
	static {
	}


	private void _Fab_Color() {
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#9E9E9E")));
	}

	@Override
	public void onBackPressed() {
		if (webview2.canGoBack()) {
			webview2.goBack();
		} else {
			intent1.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent1);
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {

						}
					});
				}
			};
			_timer.schedule(t, 350);

		}
	}

	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	@Deprecated
	public int getLocationX(View _v) {
		int[] _location = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}

	@Deprecated
	public int getLocationY(View _v) {
		int[] _location = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}

	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}

	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}

	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}

	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}

	@Override
	public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
		super.onCreateContextMenu(contextMenu, view, contextMenuInfo);

		final WebView.HitTestResult webViewHitTestResult = webview2.getHitTestResult();

		if (webViewHitTestResult.getType() == WebView.HitTestResult.IMAGE_TYPE ||
				webViewHitTestResult.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {

			contextMenu.setHeaderTitle("Сохранить изображение?");

			contextMenu.add(0, 1, 0, "Скачать")
					.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
						@Override
						public boolean onMenuItemClick(MenuItem menuItem) {

							String DownloadImageURL = webViewHitTestResult.getExtra();

							if (URLUtil.isValidUrl(DownloadImageURL)) {

								DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadImageURL));
								request.allowScanningByMediaScanner();
								request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
								DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
								downloadManager.enqueue(request);

								Toast.makeText(UlusyActivity.this, "Изображение сохранено в папке загрузок", Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(UlusyActivity.this, "Что-то пошло не так...", Toast.LENGTH_LONG).show();
							}
							return false;
						}
					});
		}
	}
}