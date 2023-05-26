package posam.sk.accountsapplication.domain;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AccountService {
    private static Map<Long, Account> accountRepository = null;


    static {
        Stream<String> accountStream = Stream.of("1,Jozko,Test,Jozko.Test@posam.sk", "2,Anezka,Testovacia,Anezka.Testovacia@posam.sk", "3,Elon,Testovic,Elon.Testovic@posam.sk", "4,Barabas,Kazistav,Barabas.Kazistav@posam.sk");
        accountRepository = accountStream.map(account -> {
                String[] info = account.split(",");
        return new Account(new Long(info[0]), info[1], info[2], info[3]);
        }).collect(Collectors.toMap(Account::getId, usr -> usr));
    }

    public Account findById(Long id) {
        return accountRepository.get(id);
    }
    public Collection<Account> findAll() {
        return accountRepository.values();
    }
}
