package aldan.talba.rf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OboutActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();


	private ScrollView vscroll2;
	private LinearLayout linear13;
	private Button button4;
	private TextView textview23;
	private TextView textview21;
	private TextView textview20;

	private Intent perehod = new Intent();
	private TimerTask t;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.obout);
		initialize();
		initializeLogic();
	}
	
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

		vscroll2 = findViewById(R.id.vscroll2);
		LinearLayout linear1 = findViewById(R.id.linear1);
		LinearLayout linear2 = findViewById(R.id.linear2);
		TextView textview1 = findViewById(R.id.textview1);
		TextView textview28 = findViewById(R.id.textview28);
		TextView textview2 = findViewById(R.id.textview2);
		LinearLayout linear8 = findViewById(R.id.linear8);
		LinearLayout linear3 = findViewById(R.id.linear3);
		TextView textview16 = findViewById(R.id.textview16);
		LinearLayout linear14 = findViewById(R.id.linear14);
		LinearLayout linear10 = findViewById(R.id.linear10);
		LinearLayout linear11 = findViewById(R.id.linear11);
		LinearLayout linear9 = findViewById(R.id.linear9);
		TextView textview30 = findViewById(R.id.textview30);
		TextView textview33 = findViewById(R.id.textview33);
		TextView textview31 = findViewById(R.id.textview31);
		TextView textview32 = findViewById(R.id.textview32);
		TextView textview22 = findViewById(R.id.textview22);
		LinearLayout linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		ImageView imageview2 = findViewById(R.id.imageview2);
		TextView textview34 = findViewById(R.id.textview34);
		Button button3 = findViewById(R.id.button3);
		TextView textview19 = findViewById(R.id.textview19);
		Button button2 = findViewById(R.id.button2);
		TextView textview18 = findViewById(R.id.textview18);
		Button button1 = findViewById(R.id.button1);
		TextView textview17 = findViewById(R.id.textview17);
		button4 = findViewById(R.id.button4);
		textview23 = findViewById(R.id.textview23);
		textview21 = findViewById(R.id.textview21);
		textview20 = findViewById(R.id.textview20);
		Button button5 = findViewById(R.id.button5);
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://wa.me/79248667227"));
				perehod.setAction(Intent.ACTION_VIEW);
				
			}
		});
		
		textview31.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://xn--80aac3b7a.xn--p1ai/"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		textview32.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://xn--80aac3b7a.xn--p1ai/mini"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://wa.me/79248667227"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		textview34.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://wa.me/79248667227"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://instagram.com/talba_site"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		textview19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://instagram.com/talba_site"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://t.me/wow_ykt_adm"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		textview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("https://t.me/wow_ykt_adm"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("mailto:niknik.ykt@yandex.ru"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		textview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				perehod.setData(Uri.parse("mailto:niknik.ykt@yandex.ru"));
				perehod.setAction(Intent.ACTION_VIEW);
				startActivity(perehod);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_ViewFadeIn(linear13, 700);
								linear13.setVisibility(View.VISIBLE);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												vscroll2.fullScroll(View.FOCUS_DOWN);
											}
										});
									}
								};
								_timer.schedule(t, 1000);
							}
						});
					}
				};
				_timer.schedule(t, 500);
				_showDeviceInfo_to_(textview20);
				_enable_copy_textview(textview20);
				SketchwareUtil.showMessage(getApplicationContext(), "секундочку)");
				button4.setVisibility(View.GONE);
				textview21.setVisibility(View.GONE);
				textview23.setVisibility(View.VISIBLE);
				_ViewFadeIn(textview23, 2500);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Copy(textview20.getText().toString());
				SketchwareUtil.showMessage(getApplicationContext(), "скопировано");
			}
		});
	}
	private void initializeLogic() {
		setTitle("О приложении");
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bgfofapppage); android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(bmp); bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT); vscroll2.setBackgroundDrawable(bitmapDrawable);
		linear13.setVisibility(View.GONE);
		textview23.setVisibility(View.GONE);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);

	}
	
	@SuppressLint("SetTextI18n")
	private void _showDeviceInfo_to_ (final TextView _tv) {
		DisplayMetrics dm = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(dm); int width = dm.widthPixels; int height = dm.heightPixels;
		
		_tv.setText( "MODEL: " + Build.MODEL + "\n\n" + "ID: " + Build.ID + "\n\n" + "Manufacture: " + Build.MANUFACTURER + "\n\n" + "Brand: " + Build.BRAND + "\n\n" +
		"Device Language: " + Locale.getDefault().getDisplayLanguage() + "\n\n" +
		"Screen Resolution: " + width + "x" + height + "\n\n" +
		"Type: " + Build.TYPE + "\n\n" + "User: " + Build.USER + "\n\n" + "BASE: " + Build.VERSION_CODES.BASE + "\n\n" + "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n\n" + "SDK: " + Build.VERSION.SDK + "\n\n" + "BOARD: " + Build.BOARD + "\n\n" + "BRAND: " + Build.BRAND + "\n\n" + "HOST: " + Build.HOST + "\n\n" + "FINGERPRINT: "+Build.FINGERPRINT + "\n\n" + "Version Code: " + Build.VERSION.RELEASE );
	}
	
	
	private void _enable_copy_textview (final TextView _tv) {
		_tv.setTextIsSelectable(true);
		
		
		//Comment Start
		
		//here "_tv" is my textview
		//join our fb group! 950+ members!
		//www.facebook.com/groups/sketchware
		//~Nikko~ enjoy guys :)
		
		//Comment End
	}
	
	
	private void _Copy (final String _text) {
		android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", _text);
		clipboard.setPrimaryClip(clip);
	}
	
	
	private void _ViewFadeIn (final View _viewFadeIn, final double _viewFadeInSetTime) {
		long x = (long)_viewFadeInSetTime;
		
		Animation fadeIn = new AlphaAnimation(0, 1); 
		fadeIn.setDuration(x);
		AnimationSet animation = new AnimationSet(true); animation.addAnimation(fadeIn);
		_viewFadeIn.startAnimation(animation);
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
	
}
