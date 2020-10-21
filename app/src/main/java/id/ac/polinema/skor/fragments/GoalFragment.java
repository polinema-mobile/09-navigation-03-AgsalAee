package id.ac.polinema.skor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import id.ac.polinema.skor.R;
import id.ac.polinema.skor.databinding.FragmentGoalBinding;
import id.ac.polinema.skor.models.GoalScorer;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalFragment extends Fragment {

	private String requestKey;
	private GoalScorer goalScorer;

	private FragmentGoalBinding binding;

	public GoalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.goalScorer = new GoalScorer();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		FragmentGoalBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false);
		binding.setFragment(this);
		binding.setGoalScorer(goalScorer);
		requestKey = GoalFragmentArgs.fromBundle(getArguments()).getRequestKey();
		return binding.getRoot();
	}

//	@Override
//	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//		super.onViewCreated(view, savedInstanceState);
//		FragmentGoalBinding binding = DataBindingUtil.setContentView(getActivity(),R.layout.fragment_goal);
//		if(getArguments().getParcelable("home")!=null){
//			binding.setGoalScorer((GoalScorer) getArguments().getParcelable("home"));
//		}else if (getArguments().getParcelable("away")!=null){
//			binding.setGoalScorer((GoalScorer) getArguments().getParcelable("away"));
//		}
//	}

	public void onSaveClicked(View view) {
		Bundle bundle = new Bundle();
		bundle.putParcelable(ScoreFragment.SCORER_KEY, goalScorer);
		getParentFragmentManager().setFragmentResult(requestKey, bundle);
		Navigation.findNavController(view).navigateUp();
	}

	public void onCancelClicked(View view) {

		Navigation.findNavController(view).navigateUp();
	}
}