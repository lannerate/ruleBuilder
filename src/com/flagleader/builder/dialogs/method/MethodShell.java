package com.flagleader.builder.dialogs.method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class MethodShell
{
  private static ResourceBundle a = ResourceBundle.getBundle("examples_addressbook");
  private Shell b;
  private Table c;
  private I d;
  private File e;
  private boolean f;
  private String[] g;
  private int h = -1;
  private static final String i = "\t";
  private static final String[] j = { a.getString("Last_name"), a.getString("First_name"), a.getString("Business_phone"), a.getString("Home_phone"), a.getString("Email"), a.getString("Fax") };

  public static void main(String[] paramArrayOfString)
  {
    Display localDisplay = new Display();
    MethodShell localMethodShell = new MethodShell();
    Shell localShell = localMethodShell.a(localDisplay);
    while (!localShell.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
    localDisplay.dispose();
  }

  public Shell a(Display paramDisplay)
  {
    this.b = new Shell(paramDisplay);
    this.b.setLayout(new FillLayout());
    this.b.addShellListener(new f(this));
    c();
    this.d = new I(this.b);
    this.d.a(j);
    this.d.b(a.getString("Column"));
    this.d.a(new q(this));
    this.c = new Table(this.b, 67588);
    this.c.setHeaderVisible(true);
    this.c.setMenu(k());
    this.c.addSelectionListener(new A(this));
    for (int k = 0; k < j.length; k++)
    {
      TableColumn localTableColumn = new TableColumn(this.c, 0);
      localTableColumn.setText(j[k]);
      localTableColumn.setWidth(150);
      int m = k;
      localTableColumn.addSelectionListener(new B(this, m));
    }
    e();
    this.b.setSize(this.c.computeSize(-1, -1).x, 300);
    this.b.open();
    return this.b;
  }

  private boolean b()
  {
    if (this.f)
    {
      localObject = new MessageBox(this.b, 456);
      ((MessageBox)localObject).setText(this.b.getText());
      ((MessageBox)localObject).setMessage(a.getString("Close_save"));
      k = ((MessageBox)localObject).open();
      if (k == 256)
        return false;
      if ((k == 64) && (!h()))
        return false;
    }
    Object localObject = this.c.getItems();
    for (int k = 0; k < localObject.length; k++)
      localObject[k].dispose();
    return true;
  }

  private Menu c()
  {
    Menu localMenu = new Menu(this.b, 2);
    this.b.setMenuBar(localMenu);
    a(localMenu);
    b(localMenu);
    c(localMenu);
    d(localMenu);
    return localMenu;
  }

  private String[] a(String paramString)
  {
    if (paramString == null)
      return null;
    String[] arrayOfString = new String[this.c.getColumnCount()];
    for (int k = 0; k < arrayOfString.length - 1; k++)
    {
      int m = paramString.indexOf("\t");
      if (m > -1)
      {
        arrayOfString[k] = paramString.substring(0, m);
        paramString = paramString.substring(m + "\t".length(), paramString.length());
      }
      else
      {
        return null;
      }
    }
    if (paramString.indexOf("\t") != -1)
      return null;
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }

  private void b(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.b, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  private void a(TableItem paramTableItem)
  {
    a locala = new a(this.b);
    locala.a(j);
    String[] arrayOfString = new String[this.c.getColumnCount()];
    for (int k = 0; k < arrayOfString.length; k++)
      arrayOfString[k] = paramTableItem.getText(k);
    locala.b(arrayOfString);
    arrayOfString = locala.d();
    if (arrayOfString != null)
    {
      paramTableItem.setText(arrayOfString);
      this.f = true;
    }
  }

  private String a(String[] paramArrayOfString)
  {
    String str = "";
    for (int k = 0; k < paramArrayOfString.length - 1; k++)
      str = str + paramArrayOfString[k] + "\t";
    str = str + paramArrayOfString[(paramArrayOfString.length - 1)] + "\n";
    return str;
  }

  private boolean d()
  {
    Cursor localCursor = new Cursor(this.b.getDisplay(), 1);
    this.b.setCursor(localCursor);
    boolean bool1 = this.d.b();
    boolean bool2 = this.d.c();
    String str = this.d.e();
    int k = this.d.g();
    str = bool1 ? str : str.toLowerCase();
    boolean bool3 = false;
    int m;
    if (this.d.f())
      for (m = this.c.getSelectionIndex() + 1; m < this.c.getItemCount(); m++)
      {
        if (!(bool3 = a(str, this.c.getItem(m), k, bool2, bool1)))
          continue;
        this.c.setSelection(m);
        break;
      }
    else
      for (m = this.c.getSelectionIndex() - 1; m > -1; m--)
      {
        if (!(bool3 = a(str, this.c.getItem(m), k, bool2, bool1)))
          continue;
        this.c.setSelection(m);
        break;
      }
    this.b.setCursor(null);
    localCursor.dispose();
    return bool3;
  }

  private boolean a(String paramString, TableItem paramTableItem, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramBoolean2 ? paramTableItem.getText(paramInt) : paramTableItem.getText(paramInt).toLowerCase();
    if (paramBoolean1)
    {
      if ((str != null) && (str.equals(paramString)))
        return true;
    }
    else if ((str != null) && (str.indexOf(paramString) != -1))
      return true;
    return false;
  }

  private void e()
  {
    this.b.setText(a.getString("Title_bar") + a.getString("New_title"));
    this.e = null;
    this.f = false;
  }

  private void f()
  {
    a locala = new a(this.b);
    locala.a(j);
    String[] arrayOfString = locala.d();
    if (arrayOfString != null)
    {
      TableItem localTableItem = new TableItem(this.c, 0);
      localTableItem.setText(arrayOfString);
      this.f = true;
    }
  }

  private void g()
  {
    FileDialog localFileDialog = new FileDialog(this.b, 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.adr;", "*.*" });
    localFileDialog.setFilterNames(new String[] { a.getString("Book_filter_name") + " (*.adr)", a.getString("All_filter_name") + " (*.*)" });
    String str1 = localFileDialog.open();
    if (str1 == null)
      return;
    File localFile = new File(str1);
    if (!localFile.exists())
    {
      b(a.getString("File") + localFile.getName() + " " + a.getString("Does_not_exist"));
      return;
    }
    Cursor localCursor = new Cursor(this.b.getDisplay(), 1);
    this.b.setCursor(localCursor);
    FileReader localFileReader = null;
    BufferedReader localBufferedReader = null;
    Object localObject1 = new String[0];
    try
    {
      localFileReader = new FileReader(localFile.getAbsolutePath());
      localBufferedReader = new BufferedReader(localFileReader);
      for (String str2 = localBufferedReader.readLine(); str2 != null; str2 = localBufferedReader.readLine())
      {
        String[] arrayOfString = new String[localObject1.length + 1];
        System.arraycopy(localObject1, 0, arrayOfString, 0, localObject1.length);
        arrayOfString[localObject1.length] = str2;
        localObject1 = arrayOfString;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      b(a.getString("File_not_found") + "\n" + localFile.getName());
      return;
    }
    catch (IOException localIOException1)
    {
      b(a.getString("IO_error_read") + "\n" + localFile.getName());
      return;
    }
    finally
    {
      this.b.setCursor(null);
      localCursor.dispose();
      if (localFileReader != null)
        try
        {
          localFileReader.close();
        }
        catch (IOException localIOException4)
        {
          b(a.getString("IO_error_close") + "\n" + localFile.getName());
          return;
        }
    }
    this.b.setCursor(null);
    localCursor.dispose();
    if (localFileReader != null)
      try
      {
        localFileReader.close();
      }
      catch (IOException localIOException5)
      {
        b(a.getString("IO_error_close") + "\n" + localFile.getName());
        return;
      }
    Object localObject2 = new String[localObject1.length][this.c.getColumnCount()];
    int k = 0;
    Object localObject4;
    for (int m = 0; m < localObject1.length; m++)
    {
      localObject4 = a(localObject1[m]);
      if (localObject4 == null)
        continue;
      localObject2[(k++)] = localObject4;
    }
    if (k != localObject1.length)
    {
      String[][] arrayOfString1 = new String[k][this.c.getColumnCount()];
      System.arraycopy(localObject2, 0, arrayOfString1, 0, k);
      localObject2 = arrayOfString1;
    }
    Arrays.sort(localObject2, new H(this, 0));
    for (int n = 0; n < localObject2.length; n++)
    {
      localObject4 = new TableItem(this.c, 0);
      ((TableItem)localObject4).setText(localObject2[n]);
    }
    this.b.setText(a.getString("Title_bar") + localFileDialog.getFileName());
    this.f = false;
    this.e = localFile;
  }

  private boolean h()
  {
    if (this.e == null)
      return i();
    Cursor localCursor = new Cursor(this.b.getDisplay(), 1);
    this.b.setCursor(localCursor);
    TableItem[] arrayOfTableItem = this.c.getItems();
    String[] arrayOfString1 = new String[arrayOfTableItem.length];
    for (int k = 0; k < arrayOfTableItem.length; k++)
    {
      String[] arrayOfString2 = new String[this.c.getColumnCount()];
      for (int n = 0; n < arrayOfString2.length; n++)
        arrayOfString2[n] = arrayOfTableItem[k].getText(n);
      arrayOfString1[k] = a(arrayOfString2);
    }
    FileWriter localFileWriter = null;
    try
    {
      localFileWriter = new FileWriter(this.e.getAbsolutePath(), false);
      for (int m = 0; m < arrayOfString1.length; m++)
        localFileWriter.write(arrayOfString1[m]);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      b(a.getString("File_not_found") + "\n" + this.e.getName());
      return false;
    }
    catch (IOException localIOException1)
    {
      b(a.getString("IO_error_write") + "\n" + this.e.getName());
      return false;
    }
    finally
    {
      this.b.setCursor(null);
      localCursor.dispose();
      if (localFileWriter != null)
        try
        {
          localFileWriter.close();
        }
        catch (IOException localIOException4)
        {
          b(a.getString("IO_error_close") + "\n" + this.e.getName());
          return false;
        }
    }
    this.b.setCursor(null);
    localCursor.dispose();
    if (localFileWriter != null)
      try
      {
        localFileWriter.close();
      }
      catch (IOException localIOException5)
      {
        b(a.getString("IO_error_close") + "\n" + this.e.getName());
        return false;
      }
    this.b.setText(a.getString("Title_bar") + this.e.getName());
    this.f = false;
    return true;
  }

  private boolean i()
  {
    FileDialog localFileDialog = new FileDialog(this.b, 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.adr;", "*.*" });
    localFileDialog.setFilterNames(new String[] { "Address Books (*.adr)", "All Files " });
    localFileDialog.open();
    String str = localFileDialog.getFileName();
    if (str.equals(""))
      return false;
    if (str.indexOf(".adr") != str.length() - 4)
      str = str + ".adr";
    File localFile = new File(localFileDialog.getFilterPath(), str);
    if (localFile.exists())
    {
      MessageBox localMessageBox = new MessageBox(this.b, 200);
      localMessageBox.setText(a.getString("Save_as_title"));
      localMessageBox.setMessage(a.getString("File") + localFile.getName() + " " + a.getString("Query_overwrite"));
      if (localMessageBox.open() != 64)
        return false;
    }
    this.e = localFile;
    return h();
  }

  private void a(int paramInt)
  {
    if (this.c.getItemCount() <= 1)
      return;
    TableItem[] arrayOfTableItem = this.c.getItems();
    String[][] arrayOfString = new String[arrayOfTableItem.length][this.c.getColumnCount()];
    int m;
    for (int k = 0; k < arrayOfTableItem.length; k++)
      for (m = 0; m < this.c.getColumnCount(); m++)
        arrayOfString[k][m] = arrayOfTableItem[k].getText(m);
    Arrays.sort(arrayOfString, new H(this, paramInt));
    if (this.h != paramInt)
    {
      this.c.setSortColumn(this.c.getColumn(paramInt));
      this.c.setSortDirection(1024);
      for (k = 0; k < arrayOfString.length; k++)
        arrayOfTableItem[k].setText(arrayOfString[k]);
      this.h = paramInt;
    }
    else
    {
      this.c.setSortDirection(128);
      k = arrayOfString.length - 1;
      for (m = 0; m < arrayOfString.length; m++)
        arrayOfTableItem[m].setText(arrayOfString[(k--)]);
      this.h = -1;
    }
  }

  private void a(Menu paramMenu)
  {
    MenuItem localMenuItem1 = new MenuItem(paramMenu, 64);
    localMenuItem1.setText(a.getString("File_menu_title"));
    Menu localMenu = new Menu(this.b, 4);
    localMenuItem1.setMenu(localMenu);
    localMenu.addMenuListener(new C(this));
    MenuItem localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("New_contact"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 78);
    localMenuItem2.addSelectionListener(new D(this));
    localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("Edit_contact"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 69);
    localMenuItem2.addSelectionListener(new E(this));
    new MenuItem(localMenu, 2);
    localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("New_address_book"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 66);
    localMenuItem2.addSelectionListener(new F(this));
    localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("Open_address_book"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 79);
    localMenuItem2.addSelectionListener(new G(this));
    localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("Save_address_book"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 83);
    localMenuItem2.addSelectionListener(new g(this));
    localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("Save_book_as"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 65);
    localMenuItem2.addSelectionListener(new h(this));
    new MenuItem(localMenu, 2);
    localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("Exit"));
    localMenuItem2.addSelectionListener(new i(this));
  }

  private MenuItem b(Menu paramMenu)
  {
    MenuItem localMenuItem1 = new MenuItem(paramMenu, 64);
    localMenuItem1.setText(a.getString("Edit_menu_title"));
    Menu localMenu1 = new Menu(this.b, 4);
    localMenuItem1.setMenu(localMenu1);
    localMenu1.addMenuListener(new j(this));
    MenuItem localMenuItem2 = new MenuItem(localMenu1, 8);
    localMenuItem2.setText(a.getString("Edit"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 69);
    localMenuItem2.addSelectionListener(new k(this));
    localMenuItem2 = new MenuItem(localMenu1, 0);
    localMenuItem2.setText(a.getString("Copy"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 67);
    localMenuItem2.addSelectionListener(new l(this));
    localMenuItem2 = new MenuItem(localMenu1, 0);
    localMenuItem2.setText(a.getString("Paste"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 86);
    localMenuItem2.addSelectionListener(new m(this));
    localMenuItem2 = new MenuItem(localMenu1, 0);
    localMenuItem2.setText(a.getString("Delete"));
    localMenuItem2.addSelectionListener(new n(this));
    new MenuItem(localMenu1, 2);
    localMenuItem2 = new MenuItem(localMenu1, 64);
    localMenuItem2.setText(a.getString("Sort"));
    Menu localMenu2 = j();
    localMenuItem2.setMenu(localMenu2);
    return localMenuItem1;
  }

  private Menu j()
  {
    Menu localMenu = new Menu(this.b, 4);
    for (int k = 0; k < j.length; k++)
    {
      MenuItem localMenuItem = new MenuItem(localMenu, 0);
      localMenuItem.setText(j[k]);
      int m = k;
      localMenuItem.addSelectionListener(new o(this, m));
    }
    return localMenu;
  }

  private void c(Menu paramMenu)
  {
    MenuItem localMenuItem = new MenuItem(paramMenu, 64);
    localMenuItem.setText(a.getString("Search_menu_title"));
    Menu localMenu = new Menu(this.b, 4);
    localMenuItem.setMenu(localMenu);
    localMenuItem = new MenuItem(localMenu, 0);
    localMenuItem.setText(a.getString("Find"));
    localMenuItem.setAccelerator(SWT.MOD1 + 70);
    localMenuItem.addSelectionListener(new p(this));
    localMenuItem = new MenuItem(localMenu, 0);
    localMenuItem.setText(a.getString("Find_next"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new r(this));
  }

  private Menu k()
  {
    Menu localMenu = new Menu(this.b, 8);
    localMenu.addMenuListener(new s(this));
    MenuItem localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(a.getString("Pop_up_new"));
    localMenuItem.addSelectionListener(new t(this));
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(a.getString("Pop_up_edit"));
    localMenuItem.addSelectionListener(new u(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(a.getString("Pop_up_copy"));
    localMenuItem.addSelectionListener(new v(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(a.getString("Pop_up_paste"));
    localMenuItem.addSelectionListener(new w(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(a.getString("Pop_up_delete"));
    localMenuItem.addSelectionListener(new x(this));
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(a.getString("Pop_up_find"));
    localMenuItem.addSelectionListener(new y(this));
    return localMenu;
  }

  private void d(Menu paramMenu)
  {
    MenuItem localMenuItem1 = new MenuItem(paramMenu, 64);
    localMenuItem1.setText(a.getString("Help_menu_title"));
    Menu localMenu = new Menu(this.b, 4);
    localMenuItem1.setMenu(localMenu);
    MenuItem localMenuItem2 = new MenuItem(localMenu, 0);
    localMenuItem2.setText(a.getString("About"));
    localMenuItem2.addSelectionListener(new z(this));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.MethodShell
 * JD-Core Version:    0.6.0
 */