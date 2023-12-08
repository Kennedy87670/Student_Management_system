package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.dto.ParentsDto;
import com.admin_student.spring_studentMs.entity.Parents;
import com.admin_student.spring_studentMs.errorAndException.ParentNotFoundException;
import com.admin_student.spring_studentMs.mapper.ParentMapper;
import com.admin_student.spring_studentMs.repository.ParentRepository;
import com.admin_student.spring_studentMs.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    @Override
    public Optional<ParentsDto> getParentById(Long parentId) throws ParentNotFoundException{
        return parentRepository.findById(parentId)
                .map(ParentMapper::mapToParentDto);
    }

    @Override
    public Parents save(Parents parents) {
        return parentRepository.save(parents);
    }

    @Override
    public void deleteParentById(Long parentId) {
        parentRepository.deleteById(parentId);
    }


    @Override
    public List<Parents> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public ParentsDto updateParentById(Long parentId, ParentsDto parentDto) throws ParentNotFoundException {
        Optional<Parents> optionalParent = parentRepository.findById(parentId);

        if (optionalParent.isPresent()) {
            Parents parent = optionalParent.get();

            parent.setFirstName(parentDto.getFirstName());
            parent.setLastName(parentDto.getLastName());
            parent.setUserName(parentDto.getUserName());
            parent.setEmail(parentDto.getEmail());

            // Save the updated parent
            parentRepository.save(parent);

            return ParentMapper.mapToParentDto(parent);

        } else {
            throw new ParentNotFoundException("Parent not found with id: " + parentId);
        }
    }

}
