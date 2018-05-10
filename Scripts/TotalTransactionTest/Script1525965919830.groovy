import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://52.14.107.181:8085/')

WebUI.setText(findTestObject('TotalTransactionTest/Page_ProjectBackend/input_username'), admin_username)

WebUI.setText(findTestObject('TotalTransactionTest/Page_ProjectBackend/input_password'), admin_password)

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_Login'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/a_Total Transaction'))

WebUI.delay(5)

def oldTransaction = WebUI.getText(findTestObject('Object Repository/TotalTransactionTest/Page_ProjectBackend/old_transaction'))

oldTransaction = oldTransaction.replaceAll('Total price: ', '')

oldTransaction = oldTransaction.replaceAll(' THB', '')

oldTransaction = oldTransaction.replaceAll(',', '')

oldTransaction = Integer.parseInt(oldTransaction)

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/old_transaction'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_Logout'))

WebUI.setText(findTestObject('TotalTransactionTest/Page_ProjectBackend/input_username'), user_username)

WebUI.setText(findTestObject('TotalTransactionTest/Page_ProjectBackend/input_password'), user_password)

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_Login'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/a_Products'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_add to cart'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_add to cart'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/Carts'))

WebUI.delay(2)

//WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/update_transaction'))
def userTransaction = WebUI.getText(findTestObject('Object Repository/TotalTransactionTest/Page_ProjectBackend/update_transaction'))

userTransaction = userTransaction.replaceAll('Total price: ', '')

userTransaction = userTransaction.replaceAll(' THB', '')

userTransaction = userTransaction.replaceAll(',', '')

userTransaction = Integer.parseInt(userTransaction)

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_confirm'))

WebUI.acceptAlert()

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/div_Well done You successfully'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_Logout'))

WebUI.setText(findTestObject('TotalTransactionTest/Page_ProjectBackend/input_username'), admin_username)

WebUI.setText(findTestObject('TotalTransactionTest/Page_ProjectBackend/input_password'), admin_password)

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_Login'))

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/a_Total Transaction'))

//WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/new_transaction'))
def newTransaction = WebUI.getText(findTestObject('Object Repository/TotalTransactionTest/Page_ProjectBackend/new_transaction'))

newTransaction = newTransaction.replaceAll('Total price: ', '')

newTransaction = newTransaction.replaceAll(' THB', '')

newTransaction = newTransaction.replaceAll(',', '')

newTransaction = Integer.parseInt(newTransaction)

WebUI.verifyEqual(newTransaction, oldTransaction + userTransaction)

WebUI.click(findTestObject('TotalTransactionTest/Page_ProjectBackend/button_Logout'))

WebUI.closeBrowser()

