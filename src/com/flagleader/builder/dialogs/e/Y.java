package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rlm.value.SheetWhere;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class Y extends f
{
  private static final int a = 450;
  private static final int b = 300;
  private TableEditor c;
  private Combo d;
  private TableItem e;
  private BuilderManager f;
  private Table g;
  private CTabFolder h;
  private List i;
  private String[] j;
  private String[] k;
  private List l;
  private ISheetAndFieldEditen m = null;

  public Y(Shell paramShell, ISheetAndFieldEditen paramISheetAndFieldEditen, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.m = paramISheetAndFieldEditen;
    this.f = paramBuilderManager;
    this.l = paramISheetAndFieldEditen.getCanSelectFields();
    if ((this.l != null) && (this.l.size() > 0))
    {
      this.j = new String[this.l.size()];
      for (n = 0; n < this.l.size(); n++)
        this.j[n] = ((IBusinessObject)this.l.get(n)).getDisplayName();
    }
    else
    {
      this.j = new String[0];
    }
    this.i = paramISheetAndFieldEditen.getCanSelectSources();
    this.k = new String[this.i.size()];
    for (int n = 0; n < this.i.size(); n++)
      this.k[n] = ((IElement)this.i.get(n)).getDisplayName();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(3));
    this.d = b(localComposite2, "sheet.SelectSheetAndFieldsDialog", 2048, 280, 12, 2);
    this.d.setItems(this.k);
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.m.getSourceSheet() != null)
      for (int n = 0; n < this.i.size(); n++)
      {
        if (!this.m.getSourceSheet().equals(this.i.get(n)))
          continue;
        this.d.select(n);
      }
    this.d.addSelectionListener(new Z(this));
    Button localButton = f(localComposite2);
    localButton.setText(b("reset.DataDialog"));
    localButton.addSelectionListener(new af(this));
    this.h = new CTabFolder(localComposite1, 0);
    this.h.setLayoutData(a(490, 340));
    this.h.setLayout(new GridLayout());
    CTabItem localCTabItem = new CTabItem(this.h, 0);
    localCTabItem.setText(b("allmappings.SelectSheetAndFieldsDialog"));
    Composite localComposite3 = new Composite(this.h, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable1 = a(localComposite3, false);
    j();
    localCTabItem.setControl(localComposite3);
    localCTabItem = new CTabItem(this.h, 0);
    localCTabItem.setText(b("conditions.SelectSheetAndFieldsDialog"));
    localComposite3 = new Composite(this.h, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable2 = a(localComposite3, true);
    a(localTable2, this.m.getSelectedConditions());
    localCTabItem.setControl(localComposite3);
    this.h.addSelectionListener(new ag(this, localTable1, localTable2));
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(1808));
    localComposite4.setLayout(a(7));
    d(localComposite4);
    b(localComposite1);
    this.h.setSelection(0);
    this.g = localTable1;
    return localComposite1;
  }

  private boolean g()
  {
    return this.h.getSelectionIndex() == 1;
  }

  private Table a(Composite paramComposite, boolean paramBoolean)
  {
    this.g = e(paramComposite);
    a(this.g, paramBoolean);
    this.c = new TableEditor(this.g);
    this.g.addMouseMoveListener(new ah(this));
    this.g.addMouseListener(new ai(this));
    return this.g;
  }

  private void h()
  {
    Object localObject1;
    Object localObject2;
    TableItem localTableItem;
    IBusinessObject localIBusinessObject;
    if (this.h.getSelectionIndex() == 0)
    {
      localObject1 = new an(this);
      if ((((an)localObject1).open() == 0) && (((an)localObject1).c() >= 0))
      {
        localObject2 = new SheetFieldMapping(((an)localObject1).b(), (IBusinessObject)this.l.get(((an)localObject1).a()));
        this.m.addChildElement((IElement)localObject2);
        localTableItem = new TableItem(this.g, 0);
        localIBusinessObject = (IBusinessObject)this.l.get(((an)localObject1).a());
        localTableItem.setText(0, ((an)localObject1).b().getDisplayName() + "-" + ((an)localObject1).b().getValueName() + "-" + ((an)localObject1).b().getValueType());
        localTableItem.setText(1, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, localIBusinessObject.getValueType());
        localTableItem.setText(3, localIBusinessObject.getValueName());
        localTableItem.setData(localObject2);
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
    else if (this.h.getSelectionIndex() == 1)
    {
      localObject1 = new aq(this);
      if ((((aq)localObject1).open() == 0) && (((aq)localObject1).e().length() > 0))
      {
        localObject2 = new SheetWhere(((aq)localObject1).e(), ((aq)localObject1).d());
        this.m.addChildElement((IElement)localObject2);
        ((SheetWhere)localObject2).setValue(((aq)localObject1).b());
        ((SheetWhere)localObject2).setNaryType(((aq)localObject1).a());
        localTableItem = new TableItem(this.g, 0);
        localIBusinessObject = ((aq)localObject1).d();
        localTableItem.setText(1, ((aq)localObject1).e());
        localTableItem.setText(0, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, ((aq)localObject1).b());
        localTableItem.setText(3, ((aq)localObject1).a());
        localTableItem.setData(localObject2);
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
  }

  private void i()
  {
    Object localObject1;
    int n;
    List localList;
    int i2;
    Object localObject2;
    if (this.h.getSelectionIndex() == 0)
    {
      localObject1 = (SheetFieldMapping)k().getData();
      n = -1;
      for (int i1 = 0; i1 < this.l.size(); i1++)
      {
        if (!this.l.get(i1).equals(((SheetFieldMapping)localObject1).getField()))
          continue;
        n = i1;
        break;
      }
      localList = this.m.getCanSelectSourceFields();
      i2 = -1;
      for (int i3 = 0; i3 < localList.size(); i3++)
      {
        if (!localList.get(i3).equals(((SheetFieldMapping)localObject1).getMappingField()))
          continue;
        i2 = i3;
        break;
      }
      localObject2 = new an(this, i2, n);
      if ((((an)localObject2).open() == 0) && ((i2 != ((an)localObject2).c()) || (n != ((an)localObject2).a())))
      {
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)k().getData();
        localSheetFieldMapping.setMappingField(((an)localObject2).b());
        localSheetFieldMapping.setField((IBusinessObject)this.l.get(((an)localObject2).a()));
        k().setText(0, ((an)localObject2).b().getDisplayName() + "-" + ((an)localObject2).b().getValueName() + "-" + ((an)localObject2).b().getValueType());
        k().setText(1, localSheetFieldMapping.getField().getDisplayName());
        k().setText(2, localSheetFieldMapping.getField().getValueType());
        k().setText(3, localSheetFieldMapping.getField().getValueName());
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
    else if (this.h.getSelectionIndex() == 1)
    {
      localObject1 = (SheetWhere)k().getData();
      n = -1;
      localList = this.m.getCanSelectSourceFields();
      for (i2 = 0; i2 < localList.size(); i2++)
      {
        if (!localList.get(i2).equals(((SheetWhere)localObject1).getField()))
          continue;
        n = i2;
        break;
      }
      if (n < 0)
        return;
      aq localaq = new aq(this, k().getText(1), n, k().getText(2), k().getText(3));
      if ((localaq.open() == 0) && ((!localaq.e().equals(k().getText(2))) || (n != localaq.c()) || (!localaq.b().equals(k().getText(0)))))
      {
        localObject2 = (SheetWhere)k().getData();
        ((SheetWhere)localObject2).setFuncName(localaq.e());
        ((SheetWhere)localObject2).setField(localaq.d());
        ((SheetWhere)localObject2).setValue(localaq.b());
        ((SheetWhere)localObject2).setNaryType(localaq.a());
        k().setText(2, ((SheetWhere)localObject2).getValue());
        k().setText(0, ((SheetWhere)localObject2).getField().getDisplayName());
        k().setText(1, localaq.e());
        k().setText(3, localaq.a());
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.g.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.e, paramInt);
    paramText.addFocusListener(new aj(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new ak(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void a(TableItem paramTableItem, int paramInt)
  {
    CCombo localCCombo = new CCombo(this.g, 8);
    List localList = this.m.getCanSelectSourceFields();
    String[] arrayOfString = (String[])null;
    int n;
    if (paramInt == 0)
    {
      arrayOfString = new String[localList.size()];
      for (n = 0; n < localList.size(); n++)
        arrayOfString[n] = (((IBusinessObject)localList.get(n)).getDisplayName() + "-" + ((IBusinessObject)localList.get(n)).getValueName() + "-" + ((IBusinessObject)localList.get(n)).getValueType());
    }
    else
    {
      arrayOfString = new String[this.l.size()];
      for (n = 0; n < this.l.size(); n++)
        arrayOfString[n] = ((IBusinessObject)this.l.get(n)).getDisplayName();
    }
    localCCombo.setItems(arrayOfString);
    localCCombo.setText(paramTableItem.getText(paramInt));
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    this.c.horizontalAlignment = 16384;
    this.c.grabHorizontal = true;
    this.c.minimumWidth = 50;
    this.c.setEditor(localCCombo, paramTableItem, paramInt);
    localCCombo.addFocusListener(new al(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.addTraverseListener(new am(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.setFocus();
  }

  private void d(Composite paramComposite)
  {
    Button localButton1 = f(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new aa(this));
    Button localButton2 = f(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new ab(this));
    Button localButton3 = f(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new ac(this));
    localButton1 = f(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new ad(this));
    Button localButton4 = f(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new ae(this));
  }

  private Table e(Composite paramComposite)
  {
    Table localTable = new Table(paramComposite, 68354);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localGridData.heightHint = 300;
    localTable.setLayoutData(localGridData);
    localTable.setLinesVisible(true);
    return localTable;
  }

  private void a(Table paramTable, List paramList)
  {
    if (paramList != null)
      for (int n = 0; n < paramList.size(); n++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        SheetWhere localSheetWhere = (SheetWhere)paramList.get(n);
        IBusinessObject localIBusinessObject = localSheetWhere.getField();
        if (localIBusinessObject != null)
        {
          localTableItem.setText(new String[] { localIBusinessObject.getDisplayName(), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
          if (!localIBusinessObject.getParent().equals(this.m.getSourceSheet()))
            localTableItem.setBackground(h.g);
        }
        else
        {
          localTableItem.setText(new String[] { b("notExits.TEXT"), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetWhere);
      }
  }

  private void j()
  {
    this.g.removeAll();
    Control[] arrayOfControl = this.g.getChildren();
    for (int n = 0; n < arrayOfControl.length; n++)
      arrayOfControl[n].dispose();
    List localList = this.m.getSelectedFields();
    if (localList != null)
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        TableItem localTableItem = new TableItem(this.g, 0);
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)localList.get(i1);
        IBusinessObject localIBusinessObject1 = localSheetFieldMapping.getField();
        IBusinessObject localIBusinessObject2 = localSheetFieldMapping.getMappingField();
        String str = null;
        if (localIBusinessObject2 != null)
        {
          str = localIBusinessObject2.getDisplayName() + "-" + localIBusinessObject2.getValueName() + "-" + localIBusinessObject2.getValueType();
        }
        else
        {
          str = b("notExits.TEXT");
          localTableItem.setBackground(h.g);
        }
        if ((localIBusinessObject1 != null) && (localIBusinessObject2 != null))
        {
          localTableItem.setText(new String[] { str, localIBusinessObject1.getDisplayName(), localIBusinessObject1.getValueType(), localIBusinessObject1.getValueName() });
          if (!localIBusinessObject1.getJavaType().a(localIBusinessObject2.getJavaType()))
            localTableItem.setBackground(h.g);
          else if (!localIBusinessObject2.getParent().equals(this.m.getSourceSheet()))
            localTableItem.setBackground(h.g);
          else if (!localIBusinessObject1.getDisplayName().equalsIgnoreCase(localIBusinessObject2.getDisplayName()))
            localTableItem.setBackground(h.h);
        }
        else
        {
          localTableItem.setText(new String[] { str, b("notExits.TEXT"), "", "" });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetFieldMapping);
      }
  }

  private void a(Table paramTable, boolean paramBoolean)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn;
    if (paramBoolean)
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldName.SelectSheetWheresDialog"));
      localTableColumn.setWidth(130);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("operateName.SelectSheetWheresDialog"));
      localTableColumn.setWidth(65);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("valueName.SelectSheetWheresDialog"));
      localTableColumn.setWidth(145);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("naryType.SelectSheetWheresDialog"));
      localTableColumn.setWidth(105);
    }
    else
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("mappingfield.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(150);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("field.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(145);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldtype.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(85);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldname.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(65);
    }
  }

  private TableItem k()
  {
    if (this.g.getSelectionIndex() >= 0)
      return this.g.getSelection()[0];
    return null;
  }

  private Button f(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
  }

  protected void okPressed()
  {
    this.m.update();
    close();
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return false;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d()
  {
    return this.g.getSelectionCount() > 0;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.g.getSelection();
    for (int n = 0; n < arrayOfTableItem.length; n++)
    {
      ((IElement)arrayOfTableItem[n].getData()).dispose();
      arrayOfTableItem[n].dispose();
    }
    this.m.getRoot().setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.Y
 * JD-Core Version:    0.6.0
 */