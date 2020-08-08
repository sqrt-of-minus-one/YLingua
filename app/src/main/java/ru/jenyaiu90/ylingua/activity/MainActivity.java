package ru.jenyaiu90.ylingua.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.jenyaiu90.ylingua.R;
import ru.jenyaiu90.ylingua.database.Database;
import ru.jenyaiu90.ylingua.entity.Language;

public class MainActivity extends AppCompatActivity
{
	private Button editLangBT;
	private ProgressBar langPB;
	private Spinner lang1SP, lang2SP;
	private RadioButton trainingRB, dictionaryRB;
	private FrameLayout fragmentFL;

	private String lang1, lang2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editLangBT = findViewById(R.id.editLangBT);
		langPB = findViewById(R.id.langPB);
		lang1SP = findViewById(R.id.lang1SP);
		lang2SP = findViewById(R.id.lang2SP);
		trainingRB = findViewById(R.id.trainingRB);
		dictionaryRB = findViewById(R.id.dictionaryRB);
		fragmentFL = findViewById(R.id.fragmentFL);

		editLangBT.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//TODO: Edit languages
			}
		});
		loadLang();
		AdapterView.OnItemSelectedListener spinnerLstn = new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				if (parent == lang1SP)
				{
					lang1 = (String)parent.getItemAtPosition(position);
				}
				else
				{
					lang2 = (String)parent.getItemAtPosition(position);
				}

				if (trainingRB.isChecked())
				{
					loadFragment(new StartFragment(MainActivity.this), false);
				}
				else
				{
					openDictionary();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{

			}
		};
		lang1SP.setOnItemSelectedListener(spinnerLstn);
		lang2SP.setOnItemSelectedListener(spinnerLstn);
		trainingRB.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				loadFragment(new StartFragment(MainActivity.this), false);
			}
		});
		dictionaryRB.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				openDictionary();
			}
		});
	}

	private void loadFragment(Fragment fragment, boolean addToStack)
	{
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragmentFL, fragment);
		if (addToStack)
		{
			transaction.addToBackStack(null);
		}
		transaction.commit();
	}

	private void loadLang()
	{
		langPB.setVisibility(View.VISIBLE);
		new Thread()
		{
			@Override
			public void run()
			{
				List<Language> languages = Database.get(MainActivity.this).languages().getAll();
				String[] langs = new String[languages.size() + 2];
				for (int i = 0; i < languages.size(); i++)
				{
					langs[i] = languages.get(i).getCode();
				}
				langs[languages.size()] = "A";
				langs[languages.size() + 1] = "B";
				ArrayAdapter<String> adapter =
						new ArrayAdapter<>(MainActivity.this,
										   android.R.layout.simple_spinner_item, langs);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				lang1SP.setAdapter(adapter);
				lang2SP.setAdapter(adapter);
				lang1 = null;
				lang2 = null;
				langPB.setVisibility(View.INVISIBLE);
			}
		}.start();
	}

	public void start()
	{
		if (lang1 == null || lang2 == null || lang1.equals(lang2))
		{
			Toast.makeText(MainActivity.this, R.string.chose_lang, Toast.LENGTH_LONG).show();
		}
		else
		{
			//TODO: Start
			Toast.makeText(MainActivity.this, "Starting will be here...", Toast.LENGTH_LONG).show();
		}
	}

	private void openDictionary()
	{
		if (lang1 == null || lang2 == null || lang1.equals(lang2))
		{
			Toast.makeText(MainActivity.this, R.string.chose_lang, Toast.LENGTH_LONG).show();
			trainingRB.setChecked(true);
			loadFragment(new StartFragment(MainActivity.this), false);
		}
		else
		{
			loadFragment(new DictionaryFragment(lang1, lang2), false);
		}
	}
}