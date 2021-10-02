package pe.edu.upc.joboffersservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.joboffersservice.entities.MailMessage;
import pe.edu.upc.joboffersservice.repositories.MailMessageRepository;
import pe.edu.upc.joboffersservice.services.MailMessageService;

import java.util.List;
import java.util.Optional;

@Service
public class MailMessageServiceImpl implements MailMessageService {
    @Autowired
    private MailMessageRepository messageRepository;

    @Override
    public MailMessage save(MailMessage mailMessage) throws Exception {
        return messageRepository.save(mailMessage);
    }

    @Override
    public List<MailMessage> findAll() throws Exception {
        return messageRepository.findAll();
    }

    @Override
    public Optional<MailMessage> findById(Long id) throws Exception {
        return messageRepository.findById(id);
    }

    @Override
    public MailMessage update(Long id, MailMessage mailMessage) throws Exception {
        mailMessage.setId(id);
        return messageRepository.save(mailMessage);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        messageRepository.deleteById(id);
    }
}
