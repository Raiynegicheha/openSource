import {AutoGrid} from "@hilla/react-crud";
import {ProjectService} from "Frontend/generated/endpoints";
import ProjectModel from "Frontend/generated/com/example/application/project/ProjectModel";


export default function ProjectView(){
    return (
        <>
        <AutoGrid service={ProjectService} model={ProjectModel} className={"h-full , m-m"}/>
        </>
    );
}