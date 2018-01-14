package app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.send;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;

import static android.app.Activity.RESULT_OK;
import static android.os.Environment.getExternalStorageDirectory;

public class SendTaskFragment extends Fragment implements SendTaskFragmentContract.View {

    private final static int MULTIPLE_REQUEST_PERMISSION = 1;
    public static final String JAG_EXTENSION = ".png";
    private static final String PHOTO_FILE_NAME = "yyyyMMdd_HHmmss";
    private ImageView imageToSend;
    private FloatingActionButton addImageButton;
    private Spinner tutorsSpinner;
    private Button sendTaskButton;
    private String uriSavedImage;
    private String imagePath;
    private List<Tutor> tutors = new ArrayList<>();
    private List<String> tutorsNames = new ArrayList<>();
    private ArrayAdapter<CharSequence> adapter;
    private String[] tmpArray;
    private EditText title;
    private EditText desc;
    private Spinner categorySpinner;
    private String selectedCalegory;

    private SendTaskFragmentPresenter presenter;
    private String selectedTutor;

    public static SendTaskFragment newInstance() {
        SendTaskFragment fragment = new SendTaskFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        addImageButton.setOnClickListener(v -> openCameraAndTakePhoto());
        setOnItemSelectedListener();
        setOnCategorySelectedListener();

        sendTaskButton.setOnClickListener(v -> {
            ParseRelation<Tutor> relation = ParseUser.getCurrentUser().getRelation("tutor_list");
            ParseQuery<Tutor> query = relation.getQuery();
            query.findInBackground((objects, e) -> {

                for (Tutor tutor : objects) {
                    if (Objects.equals(tutor.getTutorsFirstAndLastName().trim(), selectedTutor.trim())) {

                        byte[] data = uriSavedImage.getBytes();
                        ParseFile file = new ParseFile("task.png", data);
                        file.saveInBackground();

                        Task task = new Task();
                        task.setTitle(title.getText().toString());
                        task.setDescription(desc.getText().toString());
                        task.setCategory(selectedCalegory);
                        task.setTaskImage(file);
                        task.saveInBackground();

                        ParseRelation<ParseObject> relationTwo = tutor.getRelation("tasks");
                        relationTwo.add(task);
                        tutor.saveInBackground();

                        Toast.makeText(getContext(), "Wysłałes zadanie", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_task, container, false);
        presenter = new SendTaskFragmentPresenter(this);
        initComponents(view);
        loadMyTutors();
        tutorsSpinner.setSelection(1);
        setCategorySpinner();
        return view;
    }

    private void populateSpinner(String[] array) {
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tutorsSpinner.setAdapter(adapter);
    }

    private void setOnItemSelectedListener() {
        tutorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTutor = tutorsSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setOnCategorySelectedListener() {
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCalegory = categorySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setCategorySpinner() {
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.categoryItems, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
    }

    private void loadMyTutors() {
        ParseRelation<Tutor> relation = ParseUser.getCurrentUser().getRelation("tutor_list");
        ParseQuery<Tutor> query = relation.getQuery();
        query.findInBackground((objects, e) -> {
            tutors = objects;
            for (Tutor tutor : tutors) {
                tutorsNames.add(tutor.getTutorsFirstAndLastName());
            }
            tmpArray = tutorsNames.toArray(new String[tutorsNames.size()]);
            populateSpinner(tmpArray);
        });
    }

    private void openCameraAndTakePhoto() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                + ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(), Manifest.permission.CAMERA) ||
                    ActivityCompat.shouldShowRequestPermissionRationale((Activity)
                            getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                        MULTIPLE_REQUEST_PERMISSION);
            } else {
                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                        MULTIPLE_REQUEST_PERMISSION);
            }
        } else {
            savePhotoFromCameraToFile();
        }
    }

    private void savePhotoFromCameraToFile() {
        Intent imageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageIntent.resolveActivity(getContext().getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(
                        getActivity(),
                        "com.consultapp.android.fileprovider",
                        photoFile);
                imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(imageIntent, 2);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat(PHOTO_FILE_NAME).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalStorageDirectory();
        File image = File.createTempFile(
                imageFileName,
                JAG_EXTENSION,
                storageDir
        );
        uriSavedImage = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_REQUEST_PERMISSION:
                boolean isCameraPermissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean isReadExternalStoragePermissionGranted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (isCameraPermissionGranted && isReadExternalStoragePermissionGranted) {
                    savePhotoFromCameraToFile();
                } else {
                    return;
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                handleImageFromCamera();
            }
        }
    }

    private void handleImageFromCamera() {
        imagePath = uriSavedImage;
        File imageFile = new File(imagePath);
        Picasso.with(getActivity()).load(imageFile).into(imageToSend);
    }

    private void initComponents(View view) {
        imageToSend = view.findViewById(R.id.image_to_send);
        addImageButton = view.findViewById(R.id.take_photo_button);
        tutorsSpinner = view.findViewById(R.id.choose_tutor_spinner);
        sendTaskButton = view.findViewById(R.id.send_task_button);
        title = view.findViewById(R.id.title_text_edit);
        desc = view.findViewById(R.id.desc_text_edit);
        categorySpinner = view.findViewById(R.id.category_spinner);
    }
}
