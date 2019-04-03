package com.stolbunov.roman.testandroid.ui.screens.organization_information;

import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.domain.entity.organization.Picture;
import com.stolbunov.roman.domain.entity.organization.WorkTime;
import com.stolbunov.roman.domain.use_case.ILovecityUseCase;
import com.stolbunov.roman.testandroid.logger.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class OrganizationInfoViewModel extends ViewModel {
    private final ILovecityUseCase useCase;
    private final CompositeDisposable composite = new CompositeDisposable();

    private final MutableLiveData<Integer> idOrganizationLD = new MutableLiveData<>();
    private final MutableLiveData<Organization> organizationLD = new MutableLiveData<>();
    private final MutableLiveData<List<Picture>> pictureUriLD = new MutableLiveData<>();
    private final MutableLiveData<List<WorkTime>> workTimeLD = new MutableLiveData<>();

    private final MutableLiveData<Integer> currentImagePositionLD = new MutableLiveData<>();
    private final MutableLiveData<WorkTime> todayWorkTimeLD = new MutableLiveData<>();

    @Inject
    public OrganizationInfoViewModel(ILovecityUseCase useCase) {
        this.useCase = useCase;
        idOrganizationLD.observeForever(this::requestOrganization);
        organizationLD.observeForever(this::observeOrganizationLD);
        workTimeLD.observeForever(this::getTodayWorkTime);
    }


    private void observeOrganizationLD(Organization organization) {
        pictureUriLD.setValue(organization.getPicture());
        workTimeLD.setValue(organization.getWorkTime());
    }


    private void requestOrganization(Integer idOrganization) {
        composite.add(useCase.getOrganizationById(idOrganization)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        organizationLD::postValue,
                        this::errorHandling));
    }

    private void errorHandling(Throwable throwable) {
        Logger.e(getClass().getSimpleName(), throwable);
    }

    private void getTodayWorkTime(List<WorkTime> workTimes) {
        int currentDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (currentDayOfWeek == 0) {
            todayWorkTimeLD.setValue(workTimes.get(workTimes.size() - 1));
        } else {
            todayWorkTimeLD.setValue(workTimes.get(currentDayOfWeek - 1));
        }
    }

    public void setCurrentImagePosition(int position) {
        currentImagePositionLD.setValue(position);
    }

    public void setOrganizationId(int idOrganization) {
        idOrganizationLD.setValue(idOrganization);
    }

    public LiveData<Organization> getOrganizationLD() {
        return organizationLD;
    }

    public LiveData<List<Picture>> getPictureUriLD() {
        return pictureUriLD;
    }

    public ArrayList<Picture> getPictureUriList() {
        return (ArrayList<Picture>) pictureUriLD.getValue();
    }

    public LiveData<List<WorkTime>> getWorkTimeLD() {
        return workTimeLD;
    }

    public MutableLiveData<Integer> getCurrentImagePositionLD() {
        return currentImagePositionLD;
    }

    public LiveData<WorkTime> getTodayWorkTimeLD() {
        return todayWorkTimeLD;
    }
}
