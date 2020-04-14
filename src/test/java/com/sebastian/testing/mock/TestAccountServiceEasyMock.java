package com.sebastian.testing.mock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAccountServiceEasyMock {

  private AccountManager mockAccountManager;

  @BeforeEach
  public void setUp() {
    mockAccountManager = createMock("mockAccountManager", AccountManager.class);
  }

  // the core EasyMock framework can mock only interface objects 
	// (según el libro, pero = hace mock de clases en TestWebClientEasyMock).
  @Test
  public void testTransferOk() {
    Account senderAccount = new Account("1", 200);
    Account beneficiaryAccount = new Account("2", 100);

    // Start defining the expectations (definicion del comportamiento)
    // cuando es void
    mockAccountManager.updateAccount(senderAccount);
    mockAccountManager.updateAccount(beneficiaryAccount);
    // cuando tiene return
    expect(mockAccountManager.findAccountForUser("1")).andReturn(senderAccount);
    expect(mockAccountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);
    // we’re done defining the expectations
    // cambio de fase, de las expectations a los test con reply (para que funcione como mock)
    replay(mockAccountManager);

    AccountService accountService = new AccountService();
    accountService.setAccountManager(mockAccountManager);
    accountService.transfer("1", "2", 50);
    assertEquals(150, senderAccount.getBalance());
    assertEquals(150, beneficiaryAccount.getBalance());
  }

  @AfterEach
  public void tearDown() {
    verify(mockAccountManager);
  }
}
