package ru.jenyaiu90.ylingua.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import ru.jenyaiu90.ylingua.R;
import ru.jenyaiu90.ylingua.adapter.DictionaryAdapter;
import ru.jenyaiu90.ylingua.database.Database;
import ru.jenyaiu90.ylingua.database.Translations;
import ru.jenyaiu90.ylingua.entity.Translation;

public class DictionaryFragment extends Fragment
{
	private Pair<String, String> lang;

	private ProgressBar dictionaryPB;

	public DictionaryFragment(@NonNull String lang1, @NonNull String lang2)
	{
		lang = new Pair<>(lang1, lang2);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		final View view = inflater.inflate(R.layout.fragment_dictionary, container, false);

		dictionaryPB = view.findViewById(R.id.dictionaryPB);

		view.findViewById(R.id.addBT).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//TODO: Add word
			}
		});

		dictionaryPB.setVisibility(View.VISIBLE);

		new Thread()
		{
			@Override
			public void run()
			{
				List<Translation> list = Database.get(getContext()).translations()
						.getForLang(lang.first, lang.second);
				Translation[] array = new Translation[list.size()];
				list.toArray(array);
				DictionaryAdapter adapter = new DictionaryAdapter(getContext(), array);
				((ListView)view.findViewById(R.id.dictionaryLV)).setAdapter(adapter);
				dictionaryPB.setVisibility(View.INVISIBLE);
			}
		}.start();

		return view;
	}
}