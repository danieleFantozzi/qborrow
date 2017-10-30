<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="qs2" uri="/quix-strut2-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form name="forms.soggettoEditForm" novalidate
	ng-init="listMioProfilo();">
	<div class="qrow"
		ng-class="{'qhas-error': forms.soggettoEditForm.ragioneSociale.$invalid}">
		<div class="qcol-md-2 qcol-sm-2 qcol-xs-12 labelEditProfilo"></div>
		<div class="qcol-md-2 qcol-sm-4 qcol-xs-12"></div>
		<div class="qcol-md-5 qcol-sm-4 qcol-xs-12 imageEditProfilo">

			<img src="https://i.ytimg.com/vi/7erx5uAMe1s/maxresdefault.jpg"
				alt="Smiley face" height="100" width="100">

		</div>


	</div>






	<!-- 		////////////////////////////////////////////////////////////////////////////////						
 -->
	<div class="qrow"
		ng-class="{'qhas-error': forms.soggettoEditForm.ragioneSociale.$invalid}">
		<div class="qcol-md-2 qcol-sm-2 qcol-xs-12 labelEditProfilo"></div>
		<div class="qcol-md-2 qcol-sm-4 qcol-xs-12 labelEditProfilo">
			<label for="ragioneSociale"><s:text
					name="soggetto.edit.ragioneSociale" /></label>

		</div>
		<div class="qcol-md-5 qcol-sm-4 qcol-xs-12">

			<input type="text"
				ng-model="scopeController.selectedRow.ragioneSociale"
				id="ragioneSociale" name="ragioneSociale" class="qform-control" />
			<div ng-messages="forms.soggettoEditForm.ragioneSociale.$error"
				role="alert">
				<div ng-message="notNull">
					<s:text name="error.notNull" />
				</div>
				<div ng-message="invalidAK">
					<s:text name="error.invalidAK" />
				</div>
				<div ng-message="notValid">
					<s:text name="error.notValid" />
				</div>
				<div ng-message="lenght">
					<s:text name="error.lenght" />
				</div>
				<div ng-message="dateToBeforeDateFrom">
					<s:text name="error.dateToBeforeDateFrom" />
				</div>
				<div ng-message="fieldToBeforeFieldFrom">
					<s:text name="error.fieldToBeforeFieldFrom" />
				</div>
				<div ng-message="notUnique">
					<s:text name="error.notUnique" />
				</div>
				<div ng-message="min">
					<s:text name="error.min" />
				</div>
				<div ng-message="max">
					<s:text name="error.max" />
				</div>
				<div ng-message="ognl">
					<s:text name="error.ognl" />
				</div>
				<div ng-message="pattern">
					<s:text name="error.pattern" />
				</div>
				<div ng-message="notBlank">
					<s:text name="error.notBlank" />
				</div>
				<div ng-message="qvpattern.message">
					<s:text name="error.qvpattern.message" />
				</div>
				<div ng-message="string.length">
					<s:text name="error.string.length" />
				</div>
			</div>
		</div>


	</div>

	<!-- 		/////////////////////////////////////////////////////////////77
 -->
	<div class="qrow"
		ng-class="{'qhas-error': forms.soggettoEditForm.nome.$invalid}">
		<div class="qcol-md-2 qcol-sm-2 qcol-xs-12 labelEditProfilo"></div>
		<div class="qcol-md-2 qcol-sm-4 qcol-xs-12 labelEditProfilo">
			<label for="nome"><s:text name="soggetto.edit.nome" />*</label>

		</div>
		<div class="qcol-md-5 qcol-sm-4 qcol-xs-12">

			<input type="text" ng-model="scopeController.selectedRow.nome"
				id="nome" name="nome" class="qform-control" />
			<div ng-messages="forms.soggettoEditForm.nome.$error" role="alert">
				<div ng-message="notNull">
					<s:text name="error.notNull" />
				</div>
				<div ng-message="invalidAK">
					<s:text name="error.invalidAK" />
				</div>
				<div ng-message="notValid">
					<s:text name="error.notValid" />
				</div>
				<div ng-message="lenght">
					<s:text name="error.lenght" />
				</div>
				<div ng-message="dateToBeforeDateFrom">
					<s:text name="error.dateToBeforeDateFrom" />
				</div>
				<div ng-message="fieldToBeforeFieldFrom">
					<s:text name="error.fieldToBeforeFieldFrom" />
				</div>
				<div ng-message="notUnique">
					<s:text name="error.notUnique" />
				</div>
				<div ng-message="min">
					<s:text name="error.min" />
				</div>
				<div ng-message="max">
					<s:text name="error.max" />
				</div>
				<div ng-message="ognl">
					<s:text name="error.ognl" />
				</div>
				<div ng-message="pattern">
					<s:text name="error.pattern" />
				</div>
				<div ng-message="notBlank">
					<s:text name="error.notBlank" />
				</div>
				<div ng-message="qvpattern.message">
					<s:text name="error.qvpattern.message" />
				</div>
				<div ng-message="string.length">
					<s:text name="error.string.length" />
				</div>
			</div>

		</div>
	</div>

	<!-- 		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 -->

	<div class="qrow"
		ng-class="{'qhas-error': forms.soggettoEditForm.cognome.$invalid}">
		<div class="qcol-md-2 qcol-sm-2 qcol-xs-12 labelEditProfilo"></div>

		<div class="qcol-md-2 qcol-sm-4 qcol-xs-12 labelEditProfilo">
			<label for="cognome"><s:text name="soggetto.edit.cognome" />*</label>

		</div>
		<div class="qcol-md-5 qcol-sm-4 qcol-xs-12">

			<input type="text" ng-model="scopeController.selectedRow.cognome"
				id="cognome" name="cognome" class="qform-control" />
			<div ng-messages="forms.soggettoEditForm.cognome.$error" role="alert">
				<div ng-message="notNull">
					<s:text name="error.notNull" />
				</div>
				<div ng-message="invalidAK">
					<s:text name="error.invalidAK" />
				</div>
				<div ng-message="notValid">
					<s:text name="error.notValid" />
				</div>
				<div ng-message="lenght">
					<s:text name="error.lenght" />
				</div>
				<div ng-message="dateToBeforeDateFrom">
					<s:text name="error.dateToBeforeDateFrom" />
				</div>
				<div ng-message="fieldToBeforeFieldFrom">
					<s:text name="error.fieldToBeforeFieldFrom" />
				</div>
				<div ng-message="notUnique">
					<s:text name="error.notUnique" />
				</div>
				<div ng-message="min">
					<s:text name="error.min" />
				</div>
				<div ng-message="max">
					<s:text name="error.max" />
				</div>
				<div ng-message="ognl">
					<s:text name="error.ognl" />
				</div>
				<div ng-message="pattern">
					<s:text name="error.pattern" />
				</div>
				<div ng-message="notBlank">
					<s:text name="error.notBlank" />
				</div>
				<div ng-message="qvpattern.message">
					<s:text name="error.qvpattern.message" />
				</div>
				<div ng-message="string.length">
					<s:text name="error.string.length" />
				</div>
			</div>

		</div>
	</div>


	<!-- 		///////////////////////////////////////////////////////////////////////////////////////////////////////////7
 -->


	<div class="qrow"
		ng-class="{'qhas-error': forms.soggettoEditForm.email.$invalid}">
		<div class="qcol-md-2 qcol-sm-2 qcol-xs-12 labelEditProfilo"></div>
		<div class="qcol-md-2 qcol-sm-4 qcol-xs-12 labelEditProfilo">
			<label for="email"><s:text name="soggetto.edit.email" />*</label>

		</div>
		<div class="qcol-md-5 qcol-sm-4 qcol-xs-12">

			<input type="text" ng-model="scopeController.selectedRow.email"
				id="email" name="email" class="qform-control"
				  /><!-- ng-pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"  ng-required="true" -->
			<div ng-messages="forms.soggettoEditForm.email.$error" role="alert">
				<%-- <div ng-message="required">
					<s:text name="error.notValid" />
				</div> --%>
				<%-- <div ng-message="notNull">
					<s:text name="error.notNull" />
				</div> --%>
				<div ng-message="invalidAK">
					<s:text name="error.invalidAK" />
				</div>
				<%-- <div ng-message="notValid">
					<s:text name="error.notValid" />
				</div> --%>
				<div ng-message="lenght">
					<s:text name="error.lenght" />
				</div>
				<div ng-message="dateToBeforeDateFrom">
					<s:text name="error.dateToBeforeDateFrom" />
				</div>
				<div ng-message="fieldToBeforeFieldFrom">
					<s:text name="error.fieldToBeforeFieldFrom" />
				</div>
				<div ng-message="notUnique">
					<s:text name="error.notUnique" />
				</div>
				<div ng-message="min">
					<s:text name="error.min" />
				</div>
				<div ng-message="max">
					<s:text name="error.max" />
				</div>
				<div ng-message="ognl">
					<s:text name="error.ognl" />
				</div>
				<%-- <div ng-message="pattern">
					<s:text name="error.pattern" />
				</div> --%>
				<div ng-message="notBlank">
					<s:text name="error.notBlank" />
				</div>
				<%-- <div ng-message="qvpattern.message">
					<s:text name="error.qvpattern.message" />
				</div> --%>
				<div ng-message="string.length">
					<s:text name="error.string.length" />
				</div>
				<div ng-message="emailNonValida">
					<s:text name="error.notValid" />
				</div>
			</div>

		</div>
	</div>


	<!-- 		///////////////////////////////////////////////////////////////////////
 -->
	<div class="qrow"
		ng-class="{'qhas-error': forms.soggettoEditForm.dataCompleanno.$invalid}">
		<div class="qcol-md-2 qcol-sm-2 qcol-xs-12 labelEditProfilo"></div>
		<div class="qcol-md-2 qcol-sm-4 qcol-xs-12 labelEditProfilo">
			<label for="dataCompleanno"><s:text
					name="soggetto.edit.dataCompleanno" />*</label>

		</div>
		<div class="qcol-md-5 qcol-sm-4 qcol-xs-12">

			<div class="qdropdown">
				<a class="qdropdown-toggle" id="dropdown2" role="qbutton"
					data-toggle="qdropdown" data-target="#" href="#">
					<div class="qinput-group">
						<input type="text" name="dataCompleanno" id="dataCompleanno"
							class="qform-control box-input-calendar"
							data-ng-model="scopeController.selectedRow.dataCompleanno"
							presetDate="true" dateformat="DD/MM/YYYY"> <span
							class="qinput-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
				</a>
				<ul class="qdropdown-menu" role="qmenu" aria-labelledby="dLabel">
					<datetimepicker
						data-ng-model="scopeController.selectedRow.dataCompleanno"
						data-datetimepicker-config="{ minView:'day', modelType: 'Date' }" />
				</ul>
			</div>

			<div ng-messages="forms.soggettoEditForm.dataCompleanno.$error"
				role="alert">
				<div ng-message="notNull">
					<s:text name="error.notNull" />
				</div>
				<div ng-message="invalidAK">
					<s:text name="error.invalidAK" />
				</div>
				<div ng-message="notValid">
					<s:text name="error.notValid" />
				</div>
				<div ng-message="lenght">
					<s:text name="error.lenght" />
				</div>
				<div ng-message="dateToBeforeDateFrom">
					<s:text name="error.dateToBeforeDateFrom" />
				</div>
				<div ng-message="fieldToBeforeFieldFrom">
					<s:text name="error.fieldToBeforeFieldFrom" />
				</div>
				<div ng-message="notUnique">
					<s:text name="error.notUnique" />
				</div>
				<div ng-message="min">
					<s:text name="error.min" />
				</div>
				<div ng-message="max">
					<s:text name="error.max" />
				</div>
				<div ng-message="ognl">
					<s:text name="error.ognl" />
				</div>
				<div ng-message="pattern">
					<s:text name="error.pattern" />
				</div>
				<div ng-message="notBlank">
					<s:text name="error.notBlank" />
				</div>
				<div ng-message="qvpattern.message">
					<s:text name="error.qvpattern.message" />
				</div>
				<div ng-message="string.length">
					<s:text name="error.string.length" />
				</div>
				<div ng-message="dataNelFuturo">
					<s:text name="error.dataNelFuturo" />
				</div>
				<div ng-message="nonMaggiorenne">
					<s:text name="error.nonMaggiorenne" />
				</div>
			</div>

		</div>
	</div>


	<div class="box-footer qtext-center">
		<button type="button" ng-click="saveWithCompleanno(scopeController.selectedRow)"
			class="qbtn btn-framework-color">
			<i class="fa fa-floppy-o"></i>&nbsp;
			<s:text name="button.save" />
		</button>
	</div>
	</div>
</form>

